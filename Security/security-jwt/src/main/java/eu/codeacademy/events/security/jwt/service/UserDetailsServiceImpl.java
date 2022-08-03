package eu.codeacademy.events.security.jwt.service;

import eu.codeacademy.events.jpa.user.repository.UserRepository;
import eu.codeacademy.events.security.jwt.mapper.UserRoleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;
    private final UserRoleMapper mapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findUserByEmail(username)
                .map(user -> mapper.mapUserRoleFrom(user))
                .orElseThrow(() -> new UsernameNotFoundException("'" + username + "' not found!"));
    }
}