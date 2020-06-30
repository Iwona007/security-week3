package pl.iwona.securityweek3.service;

import org.springframework.stereotype.Service;
import pl.iwona.securityweek3.exception.TokenNotFoundException;
import pl.iwona.securityweek3.model.VerificationToken;
import pl.iwona.securityweek3.repository.VerificationTokenRepo;

@Service
public class VerificationTokenService {

    private VerificationTokenRepo verificationTokenRepo;

    public VerificationTokenService(VerificationTokenRepo verificationTokenRepo) {
        this.verificationTokenRepo = verificationTokenRepo;
    }

    public void saveToken(VerificationToken verificationToken) {
        verificationTokenRepo.save(verificationToken);
    }

    public VerificationToken findByValueAdmin(String value) {
        return verificationTokenRepo.findByValueAdmin(value).orElseThrow(() -> new TokenNotFoundException(value));
    }

    public VerificationToken findByValueUser(String value) {
        return verificationTokenRepo.findByValue(value).orElseThrow(() -> new TokenNotFoundException(value));
    }

    public void deleteById(Long id) {
        verificationTokenRepo.deleteById(id);
    }

    public void delete(String token) {
        verificationTokenRepo.deleteByValue(token);
    }
}
