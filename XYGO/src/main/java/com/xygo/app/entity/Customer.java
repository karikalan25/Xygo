package com.xygo.app.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="t_customer")
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "CUSTOMER")
	private String cust_name;

	@Column(name = "CUSTOMER_TYPE")
	private String customer_type;
	
	@Column(name = "CUSTOMER_DISCOUNT")
	private Integer discount;

	@Column(name = "CUSTOMER_NUM")
	private Long phone_number;
}
