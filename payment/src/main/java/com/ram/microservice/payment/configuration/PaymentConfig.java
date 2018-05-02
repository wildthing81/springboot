package com.ram.microservice.payment.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("payment-service")
public class PaymentConfiguration {

	
}
