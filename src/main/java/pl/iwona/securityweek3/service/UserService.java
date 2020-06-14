package pl.iwona.securityweek3.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
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
}
