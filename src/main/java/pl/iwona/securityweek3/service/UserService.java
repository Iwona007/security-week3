package pl.iwona.securityweek3.service;

import java.util.UUID;
import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.iwona.securityweek3.model.ApiUser;
import pl.iwona.securityweek3.model.VerificationToken;
import pl.iwona.securityweek3.repository.ApiUserRepository;
import pl.iwona.securityweek3.repository.VerificationTokenRepo;

@Service
public class UserService {

    private ApiUserRepository apiUserRepository;
    private PasswordEncoder passwordEncoder;
    private VerificationTokenRepo verificationTokenRepo;
    private MailSenderService mailSenderService;

    public UserService(ApiUserRepository apiUserRepository,
                       PasswordEncoder passwordEncoder,
                       VerificationTokenRepo verificationTokenRepo, MailSenderService mailSenderService) {
        this.apiUserRepository = apiUserRepository;
        this.passwordEncoder = passwordEncoder;
        this.verificationTokenRepo = verificationTokenRepo;
        this.mailSenderService = mailSenderService;
    }

    public void addNewUser(ApiUser user, HttpServletRequest request) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        apiUserRepository.save(user);

        String token = UUID.randomUUID().toString();
        VerificationToken verificationToken = new VerificationToken(user, token);
        verificationTokenRepo.save(verificationToken);

        String url = "http://" + request.getServerName() +
                ":" + request.getServerPort() +
                request.getContextPath() + "/verify-token?token=" + token;

        try {
            mailSenderService.sendMail(user.getUsername(), "Verification Token",
                    url, false);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public void verifyToken(String token) {
        ApiUser apiUser = verificationTokenRepo.findByValue(token).getApiUser();
        apiUser.setEnabled(true);
        apiUserRepository.save(apiUser);
    }
}
