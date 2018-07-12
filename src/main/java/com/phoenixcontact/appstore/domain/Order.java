package com.phoenixcontact.appstore.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="_order")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
    @SequenceGenerator(name="order_id_seq", sequenceName="order_id_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_id_seq")
    @Column(nullable = false, unique = true)
    @ApiModelProperty(notes = "The automatic generated order ID")
	private Long id;
    
	@NotNull
	@Column(nullable = false)
	@ApiModelProperty(notes = "Application id", required = true)
	private Long appId;

	@NotEmpty
	@Column(nullable = false)
	@ApiModelProperty(notes = "Buyer id")
	private String userUuid;
	
	@Positive
	@Column(nullable = false, unique = true)
	@ApiModelProperty(notes = "The order number")
	private Integer orderNumber;
	
	@NotNull
	@Column(nullable = false)
	@ApiModelProperty(notes = "The order date")
	private Date orderDate;
	
	@NotNull
	@PositiveOrZero
	@Column(nullable = false)
	@ApiModelProperty(notes = "The unit price (of the associated application)")
	private Double unitPrice;
	
	@NotEmpty
	@Positive
	@Column(nullable = false)
	@ApiModelProperty(notes = "The order amount")
	private Integer amount;
	
	@NotNull
	@Column(nullable = false, length = 500)
	@ApiModelProperty(notes = "The order description")
	private String description;
	
	@NotNull
	@PositiveOrZero
	@Column(nullable = false)
	@ApiModelProperty(notes = "The total price")
	private Double totalPrice;

	public Order() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((appId == null) ? 0 : appId.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((orderDate == null) ? 0 : orderDate.hashCode());
		result = prime * result + ((orderNumber == null) ? 0 : orderNumber.hashCode());
		result = prime * result + ((totalPrice == null) ? 0 : totalPrice.hashCode());
		result = prime * result + ((unitPrice == null) ? 0 : unitPrice.hashCode());
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
		Order other = (Order) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (appId == null) {
			if (other.appId != null)
				return false;
		} else if (!appId.equals(other.appId))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (orderDate == null) {
			if (other.orderDate != null)
				return false;
		} else if (!orderDate.equals(other.orderDate))
			return false;
		if (orderNumber == null) {
			if (other.orderNumber != null)
				return false;
		} else if (!orderNumber.equals(other.orderNumber))
			return false;
		if (totalPrice == null) {
			if (other.totalPrice != null)
				return false;
		} else if (!totalPrice.equals(other.totalPrice))
			return false;
		if (unitPrice == null) {
			if (other.unitPrice != null)
				return false;
		} else if (!unitPrice.equals(other.unitPrice))
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

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}



	

	
    
	
	

}
