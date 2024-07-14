package com.lg.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductExceptionHandler {

	@ExceptionHandler(value = ProductNotFoundException.class)
	public ResponseEntity<Object> productNotFoundException(ProductNotFoundException productNotFoundException) {
		ProductException productException = new ProductException(productNotFoundException.getMessage(),
				productNotFoundException.getCause(), HttpStatus.NOT_FOUND);

		return new ResponseEntity<Object>(productException, HttpStatus.NOT_FOUND);
	}

}
