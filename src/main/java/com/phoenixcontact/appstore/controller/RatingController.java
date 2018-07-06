package com.phoenixcontact.appstore.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.phoenixcontact.appstore.domain.Rating;
import com.phoenixcontact.appstore.domain.RatingId;
import com.phoenixcontact.appstore.service.RatingService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/ratings")
@Api(value="onlinestore", description="Operations pertaining to rating in Application Store")
public class RatingController {

    private RatingService ratingService;

    @Autowired
    public void setRatingService(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @ApiOperation(value = "Search a rating by composite id",response = Iterable.class)
    @RequestMapping(value = "/{compositeId}", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getRating(@PathVariable RatingId compositeId, Model model){
    	Rating storedRating = ratingService.getRatingById(compositeId);
    	if (storedRating == null) {
    		return new ResponseEntity<String>("Rating with id = " + compositeId + " not found", HttpStatus.NOT_FOUND);
    	}
        return new ResponseEntity<Rating>(storedRating, HttpStatus.OK);
    }

    
//    @ApiOperation(value = "View a list of available ratings",response = Iterable.class)
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Successfully retrieved list"),
//            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
//            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
//            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
//    }
//    )
//    @RequestMapping(method= RequestMethod.GET, produces = "application/json")
//    public Iterable<Rating> list(Model model){
//        Iterable<Rating> list = ratingService.listAllRatings();
//        return list;
//    }

    @ApiOperation(value = "Search ratings by app id",response = Iterable.class)
    @RequestMapping(value = "/byapp/{appId}", method= RequestMethod.GET, produces = "application/json")
    public Iterable<Rating> findRatingsByUser(@PathVariable Long appId, Model model){
    	Iterable<Rating> ratings = ratingService.findRatingsByApp(appId);
        return ratings;
    }

    @ApiOperation(value = "Search ratings by user uuid",response = Iterable.class)
    @RequestMapping(value = "/byuser/{uuid}", method= RequestMethod.GET, produces = "application/json")
    public Iterable<Rating> findRatingsByApp(@PathVariable String uuid, Model model){
    	Iterable<Rating> ratings = ratingService.findRatingsByUser(uuid);
        return ratings;
    }

    @ApiOperation(value = "Add a rating")
    @RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json")
    public Rating saveRating(@Valid @RequestBody Rating rating){
    	rating.setRatingDate(new Date());
    	Rating newRating = ratingService.saveRating(rating);
        return newRating;
    }

    @ApiOperation(value = "Update a rating")
    @RequestMapping(value = "", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity<?> updateRating(@Valid @RequestBody Rating rating){
        Rating storedRating = ratingService.getRatingById(rating.getRatingId());
    	if (storedRating == null) {
    		return new ResponseEntity<String>("Rating with id=" + rating.getRatingId() + " not found", HttpStatus.NOT_FOUND);
    	} else {
	        storedRating.setRatingValue(rating.getRatingValue());
	        storedRating.setReview(rating.getReview());
	        storedRating.setRatingDate(new Date());
	        ratingService.saveRating(storedRating);
        }
        return new ResponseEntity<Rating>(storedRating, HttpStatus.OK);
    }

}
