package com.policy.ms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.policy.ms.model.Customer;
import com.policy.ms.model.Policy;
import com.policy.ms.repository.PolicyRepository;

@Service
public class PolicyService {
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	PolicyRepository policyRepository;

	public Policy createPolicy(Policy policy) {
		Customer customer;
		customer = customerService.getCustomerDetails(policy.getCustomerDetails().getCustomerId());
		policy.setCustomerDetails(customer);
		return policyRepository.save(policy);
	}
	
	public List<Policy> getPolicies(){
		return policyRepository.findAll();
	}
	
	public Customer getPolicyCustomer(String policyId) {
		Optional<Policy> opt = policyRepository.findById(policyId);
		if(opt.isPresent()) {
			Policy policy = opt.get();
			return customerService.getCustomer(policy.getCustomerDetails().getCustomerId());
		}
		return null;
	}
	
	
}
