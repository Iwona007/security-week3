package pl.iwona.securityweek3.service;

import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.iwona.securityweek3.model.ApiUser;
import pl.iwona.securityweek3.model.Role;
import pl.iwona.securityweek3.model.VerificationToken;
import pl.iwona.securityweek3.repository.ApiUserRepository;

@Service
public class UserService {

    private static final String MODERATOR = "test222test222mail@gmail.com";

    private ApiUserRepository apiUserRepository;
    private PasswordEncoder passwordEncoder;
    private VerificationTokenService verificationTokenService;
    private MailSenderService mailSenderService;

    public UserService(ApiUserRepository apiUserRepository, PasswordEncoder passwordEncoder,
                       VerificationTokenService verificationTokenService, MailSenderService mailSenderService) {
        this.apiUserRepository = apiUserRepository;
        this.passwordEncoder = passwordEncoder;
        this.verificationTokenService = verificationTokenService;
        this.mailSenderService = mailSenderService;
    }

    public boolean addUser(ApiUser user, HttpServletRequest request) {
        if (apiUserRepository.findAllByUsername(user.getUsername()) == null) {
            boolean adminRole = false;
            VerificationToken verificationToken = new VerificationToken();
            String tokenForUser = generateUserToken(verificationToken);

            String tokenForAdmin = UUID.randomUUID().toString();
            if (user.getRole() == Role.ADMIN) {
                adminRole = true;
                verificationToken.setValueAdmin(tokenForAdmin);
            }

            setUserAtribute(user);

            verificationToken.setApiUser(user);
            verificationTokenService.saveToken(verificationToken);

            String urlUser = url(request, tokenForUser, "/verify-token?token=");
            mailSenderService.sendMail(user.getUsername(), "Verification Token", urlUser, false);

            return isAdminRole(request, adminRole, tokenForAdmin);
        }
        return false;
    }

    private String generateUserToken(VerificationToken verificationToken) {
        String tokenForUser = UUID.randomUUID().toString();
        verificationToken.setValue(tokenForUser);
        return tokenForUser;
    }

    private boolean isAdminRole(HttpServletRequest request, boolean adminRole, String tokenForAdmin) {
        if (adminRole) {
            String urlAdmin = url(request, tokenForAdmin, "/admin-token?token=");
            mailSenderService.sendMail(MODERATOR, "Verification Token", urlAdmin, false);
        }
        return true;
    }

    private void setUserAtribute(ApiUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        user.setEnabled(false);
        apiUserRepository.save(user);
    }

    private String url(HttpServletRequest request, String tokenForUser, String adminUserToken) {
        return "http://" + request.getServerName() + ":" +
                request.getServerPort() +
                request.getContextPath() +
                adminUserToken + tokenForUser;
    }

    public boolean verifyToken(String token) {
        VerificationToken verificationToken = verificationTokenService.findByValueUser(token);
        if (verificationToken != null) {
            ApiUser user = verificationToken.getApiUser();
            user.setEnabled(true);
            verificationTokenService.saveToken(verificationToken);
            apiUserRepository.save(user);
            String adminRole = verificationToken.getValueAdmin();
            if (adminRole == null) {
                verificationTokenService.deleteById(verificationToken.getId());
            }
            return true;
        }
        return false;
    }

    public boolean isAdmin(String token) {
        VerificationToken verificationToken = new VerificationToken();
        verificationToken = verificationTokenService.findByValueAdmin(token);
        if (verificationToken != null) {
            ApiUser user = verificationToken.getApiUser();
            user.setRole(Role.ADMIN);
            user.setEnabled(true);
            apiUserRepository.save(user);
//            verificationTokenService.deleteById(verificationToken.getId()); // odkomentowanie powoduje wyjatek TokenNOtFound
            return true;
        }
        return false;
    }
}
