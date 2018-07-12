package com.phoenixcontact.appstore.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class AppLicense implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "app_license_id_seq", sequenceName = "app_license_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "app_license_id_seq")
	@Column(nullable = false, unique = true)
	@ApiModelProperty(notes = "The automatic generated application license ID")
	private Long id;

	@NotNull
	@Column(nullable = false)
	@ApiModelProperty(notes = "Application id", required = true)
	private Long appId;

	@NotBlank
	@Column(nullable = false, length = 30)
	@ApiModelProperty(notes = "Owner of the license", required = true)
	private String userUuid;

	@ApiModelProperty(notes = "Device id where application is installed")
	private String deviceUuid;

	@NotBlank
	@Column(name = "_version", length = 10)
	@ApiModelProperty(notes = "The version of license", required = true)
	private String version;

	@NotEmpty
	@ApiModelProperty(notes = "The status of license", required = true)
	private Integer status;

	@ApiModelProperty(notes = "Is an update available for the associated application")
	private Boolean updateAvailable = false;

	public AppLicense() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Boolean getUpdateAvailable() {
		return updateAvailable;
	}

	public void setUpdateAvailable(Boolean updateAvailable) {
		this.updateAvailable = updateAvailable;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((appId == null) ? 0 : appId.hashCode());
		result = prime * result + ((deviceUuid == null) ? 0 : deviceUuid.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((updateAvailable == null) ? 0 : updateAvailable.hashCode());
		result = prime * result + ((userUuid == null) ? 0 : userUuid.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
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
		AppLicense other = (AppLicense) obj;
		if (appId == null) {
			if (other.appId != null)
				return false;
		} else if (!appId.equals(other.appId))
			return false;
		if (deviceUuid == null) {
			if (other.deviceUuid != null)
				return false;
		} else if (!deviceUuid.equals(other.deviceUuid))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (updateAvailable == null) {
			if (other.updateAvailable != null)
				return false;
		} else if (!updateAvailable.equals(other.updateAvailable))
			return false;
		if (userUuid == null) {
			if (other.userUuid != null)
				return false;
		} else if (!userUuid.equals(other.userUuid))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}

	public Long getAppId() {
		return appId;
	}

	public void setAppId(Long appId) {
		this.appId = appId;
	}

	public String getDeviceUuid() {
		return deviceUuid;
	}

	public void setDeviceUuid(String deviceUuid) {
		this.deviceUuid = deviceUuid;
	}

	public String getUserUuid() {
		return userUuid;
	}

	public void setUserUuid(String userUuid) {
		this.userUuid = userUuid;
	}

	

}
