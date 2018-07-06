package com.phoenixcontact.appstore.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="_user")
public class User {

	@Id
	@Column(length = 20)
    @ApiModelProperty(notes = "The unique id provided by ProfiCloud")
	private String uuid;

	@NotNull
	@Column(length = 20, unique = true)
	private String userName;

	@Column(length = 255)
	private String iconUrl;

	@Column(length = 50)
	private String firstName;

	@NotNull
	@Column(length = 50)
	private String lastName;

	@NotNull
	@Column(length = 50, unique = true)
	private String email;

	@NotNull
	private Boolean generalTaCAccepted;
	
	@NotNull
	private Boolean developerTaCAccepted;
	
	@NotNull
	private Boolean active;

	@NotNull
	private Date createdAt;

	@Column(length = 20)
	private String company;

	@Column(length = 500)
	private String generalInfo;

	@Column(length = 100)
	private String pcLoginToken;

//	@OneToMany(mappedBy="user")
//  private List<App> apps = new ArrayList<>();

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

	public boolean isGeneralTaCAccepted() {
		return generalTaCAccepted;
	}

	public void setGeneralTaCAccepted(boolean generalTaCAccepted) {
		this.generalTaCAccepted = generalTaCAccepted;
	}

	public boolean isDeveloperTaCAccepted() {
		return developerTaCAccepted;
	}

	public void setDeveloperTaCAccepted(boolean developerTaCAccepted) {
		this.developerTaCAccepted = developerTaCAccepted;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
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

	public String getPcLoginToken() {
		return pcLoginToken;
	}

	public void setPcLoginToken(String pcLoginToken) {
		this.pcLoginToken = pcLoginToken;
	}


}