package com.coindemo.common.model;

import java.io.Serializable;

import lombok.Data;

/**
 * Ajax处理结果对象
 */
@Data
public class Result implements Serializable {
	/**
	 * @fields serialVersionUID
	 */
	private static final long serialVersionUID = 5905715228490291386L;
	/**
	 * @fields status 状态信息，正确返回OK，否则返回 ERROR，如果返回ERROR则需要填写Message信息
	 */
	private Status status;
	/**
	 * @fields record 消息对象
	 */
	private Object message;
	
	/**
	 * @fields record 自定义消息标识
	 */
	private Object flag;

	/**
	 * 错误码
	 */
	private String errorCode="";

	public Result() {
		super();
	}

	/**
	 * @description
	 * @param status
	 *            状态
	 * @param message
	 *            消息
	 */
	public Result(Status status, Object message) {
		this.status = status;
		this.message = message;
	}

	/**
	 * @description
	 * @param status
	 *            状态
	 * @param errorCode
	 *            错误码
	 * @param message
	 *            消息
	 */
	public Result(Status status, String errorCode, Object message) {
		this.status = status;
		this.errorCode = errorCode;
		this.message = message;
	}

	/**
	 * @description
	 * @param status
	 *            状态
	 * @param errorCode
	 *            错误码
	 * @param message
	 *            消息标识
	 * @param message
	 *            消息
	 */
	public Result(Status status, String errorCode, Object flag, Object message) {
		this.status = status;
		this.errorCode = errorCode;
		this.flag = flag;
		this.message = message;
	}
	
	/**
	 * @description
	 * @param status
	 *            状态
	 * @param errorCode
	 *            错误码
	 */
	public Result(Status status, String errorCode) {
		this.status = status;
		this.errorCode = errorCode;
	}

	/**
	 * 结果类型信息
	 */
	public enum Status {
		OK, ERROR
	}

	/**
	 * 添加成功结果信息
	 * 
	 * @param record
	 */
	public void addOK(Object message) {
		this.message = message;
		this.status = Status.OK;
	}

	/**
	 * 添加错误消息
	 * 
	 * @param message
	 */
	public void addError(Object message) {
		this.message = message;
		this.status = Status.ERROR;
	}

	/**
	 * 添加错误消息
	 * 
	 * @param message
	 */
	public void addErrorCode(String errorCode) {
		this.errorCode = errorCode;
		this.status = Status.ERROR;
	}

	/**
	 * 添加错误消息和错误code
	 * 
	 * @param message
	 */
	public void addError(Object message, String errorCode) {
		this.errorCode = errorCode;
		addError(message);

	}


}
