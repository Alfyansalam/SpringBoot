package com.ust.api.Advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ust.api.Exception.UserNotFoundException;

@RestControllerAdvice
public class ApplicationExceptionHandler {
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(UserNotFoundException.class)
	public Map<String,String> handleBussinessException(UserNotFoundException ex)
	{
		Map<String,String> errormap=new HashMap<>();
		errormap.put("errormessage",ex.getMessage());
		return errormap;
	
	}

}
