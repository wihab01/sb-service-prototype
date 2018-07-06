package com.phoenixcontact.appstore.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.phoenixcontact.appstore.domain.Rating;
import com.phoenixcontact.appstore.domain.RatingId;

@RepositoryRestResource
public interface RatingRepository extends CrudRepository<Rating, RatingId>{
	
	
}
