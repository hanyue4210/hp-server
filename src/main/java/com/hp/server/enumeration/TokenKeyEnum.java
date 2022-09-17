package com.hp.server.enumeration;
/**
 * tokenKey
 */
public enum TokenKeyEnum {
	USER("Utoken_"),
	ADMIN("Atoken_");

	private String message;

	TokenKeyEnum(String message){
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


}
