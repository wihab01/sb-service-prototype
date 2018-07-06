package com.phoenixcontact.appstore.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phoenixcontact.appstore.domain.Rating;
import com.phoenixcontact.appstore.domain.RatingId;
import com.phoenixcontact.appstore.repository.RatingRepository;

@Service
public class RatingServiceImpl implements RatingService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    private RatingRepository ratingRepository;
    
    @Autowired
    private EntityManager em;


    @Autowired
    public void setRatingRepository(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    @Override
    public Rating getRatingById(RatingId id) {
        return ratingRepository.findById(id).orElse(null);
    }

    @Override
    public Iterable<Rating> findRatingsByApp(Long appId) {
        logger.debug("findRatingsByApp called");
        String queryStr = "select r from Rating r where r.ratingId.appId = :appId";
		Query sqlQuery = em.createQuery(queryStr, Rating.class);
		sqlQuery.setParameter("appId", appId);
		
		@SuppressWarnings("unchecked")
		List<Rating> results = sqlQuery.getResultList();
		return results;
    }

   @Override
   public Iterable<Rating> findRatingsByUser(String uuid) {
       logger.debug("findRatingsByUser called");
       String queryStr = "select r from Rating r where r.ratingId.userUuid = :uuid";
       Query sqlQuery = em.createQuery(queryStr, Rating.class);
       sqlQuery.setParameter("uuid", uuid);
       
       @SuppressWarnings("unchecked")
       List<Rating> results = sqlQuery.getResultList();
       return results;
   }

    @Override
    public Rating saveRating(Rating rating) {
        logger.debug("saveRating called");
        return ratingRepository.save(rating);
    }

}
