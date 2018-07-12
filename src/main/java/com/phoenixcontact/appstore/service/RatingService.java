package com.phoenixcontact.appstore.service;


import com.phoenixcontact.appstore.domain.Rating;

public interface RatingService {
	Rating getRatingById(Long id);
	
    Rating saveRating(Rating rating);

    Iterable<Rating> findRatingsByUser(String userUuid); 

    Iterable<Rating> findRatingsByApp(Long appId); 

}
