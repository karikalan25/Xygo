package com.xygo.app.dto;

import lombok.Data;

@Data
public class LocationDto {

	private Long id;
	private String location;
	private String address;
	private Integer uploadingCharge;
	private Integer locationCode;
	private String updatedBy;

}
