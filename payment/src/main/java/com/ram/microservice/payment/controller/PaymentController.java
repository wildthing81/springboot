/**
 * 
 */
package com.ram.microservice.payment.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ram.microservice.payment.domain.Payment;
import com.ram.microservice.payment.service.PaymentService;

/**
 * @author wildthing
 *
 */
@RestController
public class PaymentController {
	
	@Autowired
	PaymentService paymentService;

	@PostMapping(path="/makePayment")
	public ResponseEntity<String> makePayment(@Valid @RequestBody Payment payment){
		String paymentId=paymentService.makePayment(payment);
		return new ResponseEntity<String>(paymentId, HttpStatus.OK);
		
	}
}
