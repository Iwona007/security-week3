package pl.iwona.securityweek3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.iwona.securityweek3.model.PersistentLogin;
@Repository
public interface PersistentLoginRepo extends JpaRepository<PersistentLogin, String> {
    PersistentLogin findBySeries(String series);
    PersistentLogin deleteBySeries(String series);
}
