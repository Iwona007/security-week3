package pl.iwona.securityweek3.start;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import pl.iwona.securityweek3.model.ApiUser;
import pl.iwona.securityweek3.model.Role;
import pl.iwona.securityweek3.repository.ApiUserRepository;

@Component
public class Start {

    private ApiUserRepository apiUserRepository;
    private BCryptPasswordEncoder encoder;

    public Start(ApiUserRepository apiUserRepository, BCryptPasswordEncoder encoder) {
        this.apiUserRepository = apiUserRepository;
        this.encoder = encoder;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void addAdmin() {
        ApiUser moderator = new ApiUser("test222test222@gmail.com",
                encoder.encode("admin"),
                Role.MODERATOR, true);
        apiUserRepository.save(moderator);
    }
}
