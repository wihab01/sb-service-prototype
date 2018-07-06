package com.phoenixcontact.appstore.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RatingId implements Serializable {
	private static final long serialVersionUID = 1L;
 
	@Column(name = "app_id")
	private Long appId;
	
	@Column(name = "user_uuid")
	private String userUuid;
	
	public RatingId() {
		super();
	}

	public RatingId(Long appId, String userUuid) {
		super();
		this.appId = appId;
		this.userUuid = userUuid;
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

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RatingId)) return false;
        RatingId that = (RatingId) o;
        return Objects.equals(getAppId(), that.getAppId()) &&
                Objects.equals(getUserUuid(), that.getUserUuid());
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(getAppId(), getUserUuid());
    }

}
