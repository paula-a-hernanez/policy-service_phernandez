package com.policy.ms.service;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.policy.ms.model.Customer;

@Service
public class CustomerService {

/*	public Customer getCustomerDetails(String customerId) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Customer> response = restTemplate.getForEntity("http://localhost:8081/mongoCustomer/"+customerId , Customer.class);
		Customer customer = response.getBody();
		return customer;
	}*/
	
	
	public Customer getCustomerDetails(String customerId) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Customer> response = restTemplate.exchange("http://localhost:8081/mongoCustomer/"+customerId, HttpMethod.GET, null, Customer.class);
		Customer customer = response.getBody();
		return customer;
	}
	
	public Customer getCustomer(String customerId) {
		RestTemplate restTemplate = new RestTemplate();
		Customer response = restTemplate.getForObject("http://localhost:8081/mongoCustomer/"+customerId, Customer.class);
		return response;
	}

}
