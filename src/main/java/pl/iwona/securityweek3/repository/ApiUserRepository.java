package pl.iwona.securityweek3.repository;

import java.util.Optional;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.iwona.securityweek3.model.ApiUser;

@Repository
public interface ApiUserRepository extends JpaRepository<ApiUser, Long> {
    ApiUser findAllByUsername(String username);

    Optional<ApiUser> findByUsername(String username);
}
