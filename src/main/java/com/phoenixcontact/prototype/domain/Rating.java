package com.phoenixcontact.prototype.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;


@Entity
public class Rating implements Serializable {
	
	@Id
	@ManyToOne(fetch=FetchType.LAZY)
	//@JoinColumn(name="appid")
	private App app;

	@Id
	@ManyToOne(fetch=FetchType.LAZY)
	//@JoinColumn(name="user")
	private User user;
	
	@NotNull
	@NotEmpty
	@Min(0)
	@Max(5)
	private Integer ratingValue;
	
	@Column(length = 1000)
	@ApiModelProperty(notes = "The review of the rating")
	private String review;
	
	@NotNull
	@ApiModelProperty(notes = "The date of the rating", required = true)
	private Date date;

}
