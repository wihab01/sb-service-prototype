package com.phoenixcontact.appstore.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;


@Entity
public class Rating implements Serializable {
	private static final long serialVersionUID = 1L;
	
//	@Id
//	@ManyToOne(fetch=FetchType.LAZY)
//	private App app;
//
//	@Id
//	@ManyToOne(fetch=FetchType.LAZY)
//	private User user;
	
	@EmbeddedId
	@ApiModelProperty(notes = "Composed id", required = true)
	RatingId ratingId;
	
	@NotNull
	@NotEmpty
	@Min(0)
	@Max(5)
	@ApiModelProperty(notes = "The 'number of stars'", required = true)
	private Integer ratingValue;
	
	@Column(length = 1000)
	@ApiModelProperty(notes = "The review of the rating")
	private String review;
	
	@NotNull
	@ApiModelProperty(notes = "The date of the rating", required = true)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss'Z'") 
	private Date ratingDate;

	public Integer getRatingValue() {
		return ratingValue;
	}

	public void setRatingValue(Integer ratingValue) {
		this.ratingValue = ratingValue;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public Date getRatingDate() {
		return ratingDate;
	}

	public void setRatingDate(Date ratingDate) {
		this.ratingDate = ratingDate;
	}

	public RatingId getRatingId() {
		return ratingId;
	}

	public void setRatingId(RatingId ratingId) {
		this.ratingId = ratingId;
	}

}
