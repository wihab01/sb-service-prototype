package com.phoenixcontact.appstore.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.phoenixcontact.appstore.domain.Rating;

@RepositoryRestResource
public interface RatingRepository extends CrudRepository<Rating, Long>{
	
	
}
