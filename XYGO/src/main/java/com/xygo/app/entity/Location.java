package com.xygo.app.entity;

import java.sql.Timestamp;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "t_location")
public class Location {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "LOCATION")
	private String location;

	@Column(name = "ADDRESS")
	private String address;

	@Column(name = "UPLOADING_CHARGE")
	private Integer uploadingCharge;

	@Column(name = "LOCATION_CODE")
	private Integer locationCode;

	@Column(name = "UPDATED_BY")
	private String updatedBy;

	@UpdateTimestamp
	@Column(name = "UPDATED_AT")
	private Timestamp updatedAt;

}
