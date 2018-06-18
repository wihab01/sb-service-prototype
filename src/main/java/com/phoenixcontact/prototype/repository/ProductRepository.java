package com.phoenixcontact.prototype.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.phoenixcontact.prototype.domain.Product;

@RepositoryRestResource
public interface ProductRepository extends CrudRepository<Product, Integer>{
}
