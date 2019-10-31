package com.tyss.tyss1springboot1.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.tyss.tyss1springboot1.dto.EmployeeResponse;

@RestControllerAdvice
public class ExceptionController {
	@ExceptionHandler(Exception.class)
   public EmployeeResponse hendleException() {
	   EmployeeResponse response=new EmployeeResponse();
	   response.setStatusCode(501);
	   response.setMessage("Exception");
	   response.setDescription("You get an exception");
	   return response;
   }
}
