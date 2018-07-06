package com.phoenixcontact.appstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestParam;

import com.phoenixcontact.appstore.domain.App;

@RepositoryRestResource
public interface AppRepository extends CrudRepository<App, Long>{
	
/*	@Query("select app from App app where app.active='true' and ((app.name is null or app.name =:name) "
			+ "or (app.rating is null or app.rating =:rating))")
	List<App> findByNameAndRating(@Param(value = "name")String name, @Param(value = "rating") Integer rating);*/
	
	
	
}
