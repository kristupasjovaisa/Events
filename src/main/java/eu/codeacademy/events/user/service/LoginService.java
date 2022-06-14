package eu.codeacademy.events.user.service;

import eu.codeacademy.events.user.mapper.UserMapper;
import eu.codeacademy.events.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService implements UserDetailsService {

    private final UserRepository userRepository;
    private final UserMapper mapper;

    @Override
    public UserDetails loadUserByUsername(String nickname) throws UsernameNotFoundException {
        return userRepository.findUserByNickname(nickname)
                .map(userEntity -> mapper.mapUserRoleFrom(userEntity))
                .orElseThrow(() -> new UsernameNotFoundException("'" + nickname + "' not found!"));
    }
}
