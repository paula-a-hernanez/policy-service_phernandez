package com.policy.ms.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.policy.ms.model.Policy;

public interface PolicyRepository extends MongoRepository<Policy, String>{

}
