package com.ram.microservice.payment.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ram.microservice.payment.domain.Payment;

@RepositoryRestResource(collectionResourceRel="payment",path="payment")
public interface PaymentRepository extends MongoRepository<Payment, String> {
	
	List<Payment> findByUserId(@Param("userId") String userId);
	
	@Override
	default Optional<Payment> findById(String paymentId) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
