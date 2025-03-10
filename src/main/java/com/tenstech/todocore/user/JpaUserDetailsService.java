package com.tenstech.todocore.user;

import com.tenstech.todocore.auth.AuthDTO;
import com.tenstech.todocore.model.User;
import com.tenstech.todocore.typemapper.TypeMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class JpaUserDetailsService implements UserDetailsService {


    private final UserRepository userRepository;

    private final TypeMapper typeMapper;

    public JpaUserDetailsService(UserRepository userRepository, TypeMapper typeMapper) {
        this.userRepository = userRepository;
        this.typeMapper = typeMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return userRepository
                .findByUsername(username)
                .map(AuthUser::new)
                .orElseThrow(() -> new UsernameNotFoundException("User name not found: " + username));

    }

    public Optional<User> createUser(AuthDTO.UserRequest userDto) {
        User user = typeMapper.toUser(userDto);
        return Optional.of(userRepository.save(user));
    }

}