package com.ram.microservice.payment.exception.handler;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ram.microservice.payment.exception.ErrorResponse;
import com.ram.microservice.payment.exception.PaymentException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class PaymentExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(PaymentException.class)
	public final ResponseEntity<ErrorResponse> handlePaymentError(PaymentException pe){
		String msg="Payment Failure";
		ErrorResponse errorResponse=new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR,msg,pe.getMessage());
		
		return new ResponseEntity<ErrorResponse>(errorResponse,errorResponse.getHttpStatus());
		
	}
	
	

}
