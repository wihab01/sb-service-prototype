package com.phoenixcontact.appstore.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class UserPrincipal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "user_principal_id_seq", sequenceName = "user_principal_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_principal_id_seq")
	@ApiModelProperty(notes = "The automatic generated user principal ID")
	private Long id;

	@NotBlank
	@Column(nullable = false, length = 30)
	@ApiModelProperty(notes = "The related user", required = true)
	private String userUuid;
	
	@Column(length = 100)
	@ApiModelProperty(notes = "Token to access the app store")
	private String storeToken;
	
	@Column(length = 100)
	@ApiModelProperty(notes = "Token to access ProfiCloud")
	private String pcToken;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserUuid() {
		return userUuid;
	}

	public void setUserUuid(String userUuid) {
		this.userUuid = userUuid;
	}

	public String getStoreToken() {
		return storeToken;
	}

	public void setStoreToken(String storeToken) {
		this.storeToken = storeToken;
	}

	public String getPcToken() {
		return pcToken;
	}

	public void setPcToken(String pcToken) {
		this.pcToken = pcToken;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((pcToken == null) ? 0 : pcToken.hashCode());
		result = prime * result + ((storeToken == null) ? 0 : storeToken.hashCode());
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
		UserPrincipal other = (UserPrincipal) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (pcToken == null) {
			if (other.pcToken != null)
				return false;
		} else if (!pcToken.equals(other.pcToken))
			return false;
		if (storeToken == null) {
			if (other.storeToken != null)
				return false;
		} else if (!storeToken.equals(other.storeToken))
			return false;
		if (userUuid == null) {
			if (other.userUuid != null)
				return false;
		} else if (!userUuid.equals(other.userUuid))
			return false;
		return true;
	}
	
}
