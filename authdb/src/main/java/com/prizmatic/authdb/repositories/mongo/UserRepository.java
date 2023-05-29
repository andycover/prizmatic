package com.prizmatic.authdb.repositories.mongo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import org.springframework.security.core.userdetails.User;

@RepositoryRestResource
public interface UserRepository extends ReactiveMongoRepository<User, String> {
}
