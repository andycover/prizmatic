package com.prizmatic.authdb;

import java.util.Collections;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import com.prizmatic.authdb.repositories.mongo.UserRepository;

@Component
public class DevDataLoader implements CommandLineRunner {

    private final UserRepository userRepository;

    public DevDataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (!userRepository.existsById("admin")) {
            User admin = new User();
            admin.setUsername("admin");
            admin.setPassword("{noop}password");
            admin.setRoles(Collections.singletonList("ROLE_ADMIN"));
            userRepository.save(admin);
        }
    }
}

