package com.prizmatic.authdb.repositories.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import org.springframework.security.core.userdetails.User;

@Service
public class MongoReactiveUserDetailsService implements ReactiveUserDetailsService {
    @Autowired
    private UserRepository userRepository;

    public MongoReactiveUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Mono<UserDetails> findByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findById(username)
                .map(user -> User.withUsername(username)
                        .password(user.getPassword())
                        .authorities(user.getAuthorities())
                        .build());
    }

}
