package com.xygo.app.utils;

import org.springframework.http.HttpStatus;

public class Response {

	/**
	 * 
	 * @param e
	 * @param status
	 * @return
	 */
	public static APIResponse<?> getFailureResponse(Exception e, HttpStatus status) {
		APIResponse<?> response = new APIResponse<>();
		response.setStatus(status);
		response.setMessage(e.getMessage());
		return response;
	}

	/**
	 * 
	 * @param <T>
	 * @param data
	 * @param message
	 * @param status
	 * @return
	 */
	public static <T> APIResponse<T> getSuccessResponse(T data, String message, HttpStatus status) {
		APIResponse<T> response = new APIResponse<>();
		response.setData(data);
		response.setStatus(status);
		response.setMessage(message);
		return response;
	}
}
