package com.phoenixcontact.appstore.repository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.phoenixcontact.appstore.domain.User;

import org.springframework.data.repository.CrudRepository;

@RepositoryRestResource
public interface UserRepository extends CrudRepository<User, String> {

}
