package com.phoenixcontact.appstore.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;


@Entity
public class App {
    @Id
    @SequenceGenerator(name="app_id_seq", sequenceName="app_id_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "app_id_seq")
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(notes = "The database generated application ID")
	private Long id;
    @ApiModelProperty(notes = "The application name", required = true)
    @Column(nullable=false, length=255)
    @NotBlank
    private String name;
    @ApiModelProperty(notes = "The application description")
    @Column(length=1000)
    private String description;
    @ApiModelProperty(notes = "News for the latest version of an app")
    @Column(length=400)
    private String whatsNew;
    @ApiModelProperty(notes = "The icon URL of the application")
    @Column(length=255)
    private String iconUrl;
    @ApiModelProperty(notes = "Number of downloads of the application", required = true)
    @NotNull
    @PositiveOrZero
    private Integer downloads;
    @ApiModelProperty(notes = "The price of the application", required = true)
    @NotNull
    @PositiveOrZero
    private BigDecimal price;
    @ApiModelProperty(notes = "Application released")
    @Column(nullable=false)
    private boolean active = false;
    @ApiModelProperty(notes = "Application version")
    @Column(nullable=false, length=20)
    @NotBlank
    private String version;
    @ApiModelProperty(notes = "Last update date")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss'Z'")
	@NotNull
	private Date lastUpdate;
    @ApiModelProperty(notes = "Calculated median rating")
    private Double rating;
    @ApiModelProperty(notes = "Developer of the app", required = true)
    @ManyToOne(fetch=FetchType.LAZY)
    //@NotNull
    @JoinColumn(name="user_uuid")
    private User user;
    
    public String getDescription() {
        return description;
    }

	public void setDescription(String description) {
        this.description = description;
    }


	public Double getRating() {
		return rating;
	}

	protected void setRating(Double rating) {
		this.rating = rating;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getWhatsNew() {
		return whatsNew;
	}

	public void setWhatsNew(String whatsNew) {
		this.whatsNew = whatsNew;
	}

	public Integer getDownloads() {
		return downloads;
	}

	public void setDownloads(Integer downloads) {
		this.downloads = downloads;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
}
