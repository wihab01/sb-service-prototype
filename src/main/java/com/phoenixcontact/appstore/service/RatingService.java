package com.phoenixcontact.appstore.service;


import com.phoenixcontact.appstore.domain.Rating;
import com.phoenixcontact.appstore.domain.RatingId;

public interface RatingService {
	Rating getRatingById(RatingId id);
	
    Rating saveRating(Rating rating);

    Iterable<Rating> findRatingsByUser(String uuid); 

    Iterable<Rating> findRatingsByApp(Long appId); 

}
