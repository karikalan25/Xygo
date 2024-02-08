package com.xygo.app.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xygo.app.dto.CustomerDto;
import com.xygo.app.entity.Customer;
import com.xygo.app.repo.CustomerRepo;
import com.xygo.app.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepo customerRepo;

	@Override
	public Customer saveCustomer(CustomerDto customerDto) {
		Customer customers = new Customer();
		BeanUtils.copyProperties(customerDto, customers);
		Customer customer = customerRepo.save(customers);
		return customer;
	}

	@Override
	public List<Customer> getCustomers() {
		return customerRepo.findAll();
	}

	@Override
	public Customer getCustomerById(Long Id) {
		return customerRepo.findById(Id).orElseThrow();
	}

	@Override
	public Customer updateCustomer(Long Id, CustomerDto customerDto) {
		Customer customer = customerRepo.findById(Id).orElseThrow();
		BeanUtils.copyProperties(customerDto, customer);
		return customerRepo.save(customer);
	}

	@Override
	public void deleteCustomerById(Long Id) {
		customerRepo.deleteById(Id);
		
	}
	
	
}
