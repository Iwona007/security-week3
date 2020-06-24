package pl.iwona.securityweek3.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.iwona.securityweek3.model.ApiUser;
import pl.iwona.securityweek3.model.Role;

@Repository
public interface ApiUserRepository extends JpaRepository<ApiUser, Long> {
   Optional<ApiUser> findAllByUsername(String username);
   Optional<ApiUser> findByUsername(String username);
}
