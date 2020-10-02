package com.policy.ms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.policy.ms.model.Customer;
import com.policy.ms.model.Policy;
import com.policy.ms.service.PolicyService;

@RestController
public class PolicyController {
	
	@Autowired
	PolicyService policyService;
	
	@RequestMapping(value="/hello")
	public String hello() {
		return "Oh hi there!";
	}
	
	@RequestMapping(value="/policy", method= RequestMethod.POST)
	public Policy creatPolicy(@RequestBody Policy policy) {
		return policyService.createPolicy(policy);
	}
	
	@RequestMapping(value="/policies", method= RequestMethod.GET)
	public List<Policy> creatPolicies() {
		return policyService.getPolicies();
	}
	
	@RequestMapping(value="/policy/customer/{policyID}", method= RequestMethod.GET)
	public Customer getPolicyCustomer(@PathVariable("policyID") String policyId) {
		return policyService.getPolicyCustomer(policyId);
	}
}
