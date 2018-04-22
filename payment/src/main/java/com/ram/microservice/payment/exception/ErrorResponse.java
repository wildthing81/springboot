package com.ram.microservice.payment.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ErrorResponse {

	private HttpStatus httpStatus;
	private String message;
	private String detailedMsg;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime timestamp;
	
	public ErrorResponse(){
		LocalDateTime.now();
	}
	public ErrorResponse(HttpStatus methodFailure, String message, String detailedMsg) {
		this();
		this.httpStatus=methodFailure;
		this.message=message;
		this.detailedMsg=detailedMsg;
	}
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetailedMsg() {
		return detailedMsg;
	}
	public void setDetailedMsg(String detailedMsg) {
		this.detailedMsg = detailedMsg;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	
}
