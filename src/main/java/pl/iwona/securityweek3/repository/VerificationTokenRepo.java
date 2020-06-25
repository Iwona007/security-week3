package pl.iwona.securityweek3.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.iwona.securityweek3.model.VerificationToken;

@Repository
public interface VerificationTokenRepo extends JpaRepository<VerificationToken, Long> {
    Optional<VerificationToken> findByValue(String value);
    Optional<VerificationToken> findByValueAdmin(String value);
    Optional<VerificationToken> deleteByValue(String value);
}
