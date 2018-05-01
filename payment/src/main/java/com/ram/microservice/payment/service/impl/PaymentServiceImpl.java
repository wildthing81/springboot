package com.ram.microservice.payment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ram.microservice.payment.configuration.PaymentConfiguration;
import com.ram.microservice.payment.entities.Payment;
import com.ram.microservice.payment.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	PaymentConfiguration pymtConfiguration;
	
	@Override
	public String makePayment(Payment payment) {
		// TODO Auto-generated method stub
		return null;
	}

}
