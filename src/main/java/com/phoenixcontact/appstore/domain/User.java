package com.phoenixcontact.appstore.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="_user")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(length = 30)
    @ApiModelProperty(notes = "The unique id provided by ProfiCloud", required = true)
	private String uuid;

	@NotNull
	@Column(length = 20, unique = true)
    @ApiModelProperty(notes = "User name (managed by ProfiCloud)", required = true)
	private String userName;

	@Column(length = 255)
	@ApiModelProperty(notes = "The icon URL of the user")
	private String iconUrl;

	@Column(length = 50)
	@ApiModelProperty(notes = "User first name")
	private String firstName;

	@NotNull
	@Column(length = 50)
	@ApiModelProperty(notes = "User last name")
	private String lastName;

	@NotNull
	@Column(length = 50, unique = true)
    @ApiModelProperty(notes = "Email address (managed by ProfiCloud)", required = true)
	private String email;

	@NotNull
    @ApiModelProperty(notes = "Developers terms and conditions accepted", required = true)
	private Boolean generalTaCAccepted;
	
	@NotNull
    @ApiModelProperty(notes = "Developers terms and conditions accepted", required = true)
	private Boolean developerTaCAccepted;
	
	@NotNull
    @ApiModelProperty(notes = "User active or not", required = true)
	private Boolean active;

	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    @ApiModelProperty(notes = "Creation date", required = true)
	private Date createdAt;

	@Column(length = 20)
    @ApiModelProperty(notes = "Company name")
	private String company;

	@Column(length = 500)
    @ApiModelProperty(notes = "General info about the user/developer")
	private String generalInfo;

	@Transient
    @ApiModelProperty(notes = "Calculated median rating")
    private Double rating;

	public User() {
		super();
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getIconUrl() {
		return iconUrl;
	}

	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getGeneralTaCAccepted() {
		return generalTaCAccepted;
	}

	public void setGeneralTaCAccepted(Boolean generalTaCAccepted) {
		this.generalTaCAccepted = generalTaCAccepted;
	}

	public Boolean getDeveloperTaCAccepted() {
		return developerTaCAccepted;
	}

	public void setDeveloperTaCAccepted(Boolean developerTaCAccepted) {
		this.developerTaCAccepted = developerTaCAccepted;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getGeneralInfo() {
		return generalInfo;
	}

	public void setGeneralInfo(String generalInfo) {
		this.generalInfo = generalInfo;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((active == null) ? 0 : active.hashCode());
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
		result = prime * result + ((developerTaCAccepted == null) ? 0 : developerTaCAccepted.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((generalInfo == null) ? 0 : generalInfo.hashCode());
		result = prime * result + ((generalTaCAccepted == null) ? 0 : generalTaCAccepted.hashCode());
		result = prime * result + ((iconUrl == null) ? 0 : iconUrl.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		result = prime * result + ((uuid == null) ? 0 : uuid.hashCode());
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
		User other = (User) obj;
		if (active == null) {
			if (other.active != null)
				return false;
		} else if (!active.equals(other.active))
			return false;
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		if (createdAt == null) {
			if (other.createdAt != null)
				return false;
		} else if (!createdAt.equals(other.createdAt))
			return false;
		if (developerTaCAccepted == null) {
			if (other.developerTaCAccepted != null)
				return false;
		} else if (!developerTaCAccepted.equals(other.developerTaCAccepted))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (generalInfo == null) {
			if (other.generalInfo != null)
				return false;
		} else if (!generalInfo.equals(other.generalInfo))
			return false;
		if (generalTaCAccepted == null) {
			if (other.generalTaCAccepted != null)
				return false;
		} else if (!generalTaCAccepted.equals(other.generalTaCAccepted))
			return false;
		if (iconUrl == null) {
			if (other.iconUrl != null)
				return false;
		} else if (!iconUrl.equals(other.iconUrl))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (rating == null) {
			if (other.rating != null)
				return false;
		} else if (!rating.equals(other.rating))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (uuid == null) {
			if (other.uuid != null)
				return false;
		} else if (!uuid.equals(other.uuid))
			return false;
		return true;
	}

	

}