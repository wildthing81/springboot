package com.ram.microservice.payment.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ram.microservice.payment.domain.Payment;

@RepositoryRestResource(collectionResourceRel="payment",path="payment")
public interface PaymentRepository extends MongoRepository<Payment, String>{
	
	List<Payment> findByUserId(@Param("userId") String userId);
	
	List<Payment> findByPymntDateTimeGreaterThan(@Param("pymntDateTime") LocalDateTime pymntDateTime);
	
	List<Payment> findByPymntDateTimeLessThan(@Param("pymntDateTime") LocalDateTime pymntDateTime);
}
