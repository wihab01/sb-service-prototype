package com.phoenixcontact.prototype.repository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.repository.CrudRepository;
import com.phoenixcontact.prototype.domain.User;

@RepositoryRestResource
public interface UserRepository extends CrudRepository<User, String> {

}
