package com.xygo.app.service;

import java.util.List;

import com.xygo.app.dto.CustomerDto;
import com.xygo.app.entity.Customer;

public  interface CustomerService {

	 Customer saveCustomer(CustomerDto customerDto);
	 List<Customer> getCustomers();
	 Customer getCustomerById(Long id);
	 Customer updateCustomer(Long Id, CustomerDto customerDto);
	 void deleteCustomerById(Long Id);

}
