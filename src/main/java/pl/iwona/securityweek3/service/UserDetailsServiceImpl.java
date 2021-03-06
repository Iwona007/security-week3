package pl.iwona.securityweek3.service;

import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.iwona.securityweek3.repository.ApiUserRepository;

@Primary
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private ApiUserRepository apiUserRepository;

    public UserDetailsServiceImpl(ApiUserRepository apiUserRepository) {
        this.apiUserRepository = apiUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return apiUserRepository.findAllByUsername(s);
    }
}
