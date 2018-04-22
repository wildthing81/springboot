package com.ram.microservice.payment.service;

import com.ram.microservice.payment.domain.Payment;

public interface PaymentService {

	String makePayment(Payment payment);

}
