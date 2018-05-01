package com.ram.microservice.payment.service;

import com.ram.microservice.payment.entities.Payment;

public interface PaymentService {

	String makePayment(Payment payment);

}
