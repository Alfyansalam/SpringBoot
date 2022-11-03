package com.ust.api.Exception;

import java.util.Map;

public class UserNotFoundException extends Exception{
	private static final long serialVersionUID=1l;
	public UserNotFoundException(String message)
	{
		super(message);
	}

}
