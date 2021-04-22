package com.compassdev.model;

public class ResponseBody<T> {

	String errorMessage;
	int errorCode;
	T resultBody;
	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}
	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	/**
	 * @return the errorCode
	 */
	public int getErrorCode() {
		return errorCode;
	}
	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	/**
	 * @return the resultBody
	 */
	public T getResultBody() {
		return resultBody;
	}
	/**
	 * @param resultBody the resultBody to set
	 */
	public void setResultBody(T resultBody) {
		this.resultBody = resultBody;
	}
	
	


}
