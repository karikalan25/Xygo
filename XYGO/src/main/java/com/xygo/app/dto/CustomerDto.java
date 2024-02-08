package com.xygo.app.dto;

import lombok.Data;

@Data
public class CustomerDto {

	private Long id;
	private String cust_name;
	private String customer_type;
	private Integer discount;
	private Long phone_number;
}
