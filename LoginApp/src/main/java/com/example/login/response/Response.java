package com.example.login.response;

public class Response {

	private Integer statusCode;
	
	private String message;
	
	private Object data;
	
	public Response() {
		
		
	}

	public Response(Integer statusCode, String message, Object data) {
		this.statusCode = statusCode;
		this.message = message;
		this.data = data;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Response [statusCode=" + statusCode + ", message=" + message + ", data=" + data + "]";
	}
	
	
	
}
