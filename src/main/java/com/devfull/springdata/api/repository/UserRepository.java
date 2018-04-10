package com.devfull.springdata.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.devfull.springdata.api.entity.User;

public interface UserRepository extends MongoRepository<User, String> {

	User findByEmail(String email);

}