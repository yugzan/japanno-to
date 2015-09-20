package org.yugzan.japannoto.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author  yugzan
 * @date    2015年9月20日
 * @project japanno-to
 */
@ResponseStatus(HttpStatus.NOT_FOUND )
public class ResourceNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public static final String REASON ="resource %s was not found.";
	
	public ResourceNotFoundException() {
		super(String.format(REASON, "item"));
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ResourceNotFoundException(String message, Throwable cause) {
		super(message, cause);

	}

	/**
	 * @param message
	 */
	public ResourceNotFoundException(String message) {
		super(message);

	}

}

