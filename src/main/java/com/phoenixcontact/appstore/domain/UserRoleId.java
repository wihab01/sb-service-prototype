package com.phoenixcontact.appstore.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;

import io.swagger.annotations.ApiModelProperty;

@Embeddable
public class UserRoleId implements Serializable {
	private static final long serialVersionUID = 1L;
 
	@ApiModelProperty(notes = "Foreign key to user principal", required = true)
	private Long principalId;
	
	@ApiModelProperty(notes = "Foreign key to user role", required = true)
	private Long roleId;
	
	public UserRoleId(Long principalId, Long roleId) {
		super();
		this.principalId = principalId;
		this.roleId = roleId;
	}

	public Long getPrincipalId() {
		return principalId;
	}

	public void setPrincipalId(Long principalId) {
		this.principalId = principalId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((principalId == null) ? 0 : principalId.hashCode());
		result = prime * result + ((roleId == null) ? 0 : roleId.hashCode());
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
		UserRoleId other = (UserRoleId) obj;
		if (principalId == null) {
			if (other.principalId != null)
				return false;
		} else if (!principalId.equals(other.principalId))
			return false;
		if (roleId == null) {
			if (other.roleId != null)
				return false;
		} else if (!roleId.equals(other.roleId))
			return false;
		return true;
	}

}
