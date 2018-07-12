package com.phoenixcontact.appstore.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;


@Entity
public class Rating implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "rating_id_seq", sequenceName = "rating_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rating_id_seq")
	@Column(nullable = false, unique = true)
	@ApiModelProperty(notes = "The automatic generated rating ID")
	private Long id;
		
	@NotNull
	@Column(nullable = false)
	@ApiModelProperty(notes = "Related application", required = true)
	private Long appId;
	
	@NotBlank
	@Column(nullable = false, length = 30)
	@ApiModelProperty(notes = "User who created this rating", required = true)
	private String userUuid;
	
	@NotNull
	@NotEmpty
	@Min(0)
	@Max(5)
	@Column(name="rating_value")
	@ApiModelProperty(notes = "The 'number of stars' (0 - 5)", required = true)
	private Integer ratingValue;
	
	@Column(length = 1000)
	@ApiModelProperty(notes = "The review of the rating")
	private String review;
	
	@NotNull
	@ApiModelProperty(notes = "The date of the rating", required = true)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss'Z'") 
	private Date ratingDate;

	public Rating() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((appId == null) ? 0 : appId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((ratingDate == null) ? 0 : ratingDate.hashCode());
		result = prime * result + ((ratingValue == null) ? 0 : ratingValue.hashCode());
		result = prime * result + ((review == null) ? 0 : review.hashCode());
		result = prime * result + ((userUuid == null) ? 0 : userUuid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rating other = (Rating) obj;
		if (appId == null) {
			if (other.appId != null)
				return false;
		} else if (!appId.equals(other.appId))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (ratingDate == null) {
			if (other.ratingDate != null)
				return false;
		} else if (!ratingDate.equals(other.ratingDate))
			return false;
		if (ratingValue == null) {
			if (other.ratingValue != null)
				return false;
		} else if (!ratingValue.equals(other.ratingValue))
			return false;
		if (review == null) {
			if (other.review != null)
				return false;
		} else if (!review.equals(other.review))
			return false;
		if (userUuid == null) {
			if (other.userUuid != null)
				return false;
		} else if (!userUuid.equals(other.userUuid))
			return false;
		return true;
	}

	public Long getAppId() {
		return appId;
	}

	public void setAppId(Long appId) {
		this.appId = appId;
	}

	public String getUserUuid() {
		return userUuid;
	}

	public void setUserUuid(String userUuid) {
		this.userUuid = userUuid;
	}

	
}
