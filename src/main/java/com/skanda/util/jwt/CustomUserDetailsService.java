package com.skanda.util.jwt;

import com.skanda.util.repository.UserRepository;
import com.skanda.util.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        UserEntity user = userRepository.findById(Long.parseLong(userId))
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        List<GrantedAuthority> authorities = List.of(
                new SimpleGrantedAuthority(user.getRole().name()) // keep as-is: ADMIN/USER
        );

        return new org.springframework.security.core.userdetails.User(
                String.valueOf(user.getUserId()),
                user.getPassword(),
                authorities
        );
    }
}
