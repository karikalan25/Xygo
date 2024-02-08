package com.xygo.app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.xygo.app.dto.CustomerDto;
import com.xygo.app.entity.Customer;
import com.xygo.app.service.CustomerService;
import com.xygo.app.utils.APIResponse;
import com.xygo.app.utils.Response;


@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/customer")
	public APIResponse<?> saveEmployeePay(@RequestBody CustomerDto customerDto) {
		try {
			Customer customer = customerService.saveCustomer(customerDto);
			return Response.getSuccessResponse(customer, "Customer Saved Successfully", HttpStatus.OK);
		} catch (Exception e) {
			return Response.getFailureResponse(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/customers")
	public APIResponse<?> getCustomer() {
		try {
			List<Customer> customer = customerService.getCustomers();
			return Response.getSuccessResponse(customer, "success", HttpStatus.OK);
		} catch (Exception e) {
			return Response.getFailureResponse(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/customer/{id}")
	public APIResponse<?> getCustomerById(@PathVariable("id") Long id) {
		try {
			Customer customer = customerService.getCustomerById(id);
			return Response.getSuccessResponse(customer, "success", HttpStatus.OK);
		} catch (Exception e) {
			return Response.getFailureResponse(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PutMapping("/customer/{id}")
	public APIResponse<?> updateLocation(@PathVariable Long id, @RequestBody CustomerDto customerDto) {
		try {
			Customer customer = customerService.updateCustomer(id, customerDto);
			return Response.getSuccessResponse(customer, "Customer Updated Successfully", HttpStatus.OK);
		} catch (Exception e) {
			return Response.getFailureResponse(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@DeleteMapping("/customer/{id}")
	public APIResponse<?> customerLocationById(@PathVariable("id") Long id) {
		try {
			customerService.deleteCustomerById(id);
			return Response.getSuccessResponse(null, "Customer Deleted Successfully", HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return Response.getFailureResponse(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
