package com.unievents.exception;

import com.unievents.common.ApiResponse;
import com.unievents.enums.BaseCode;
import lombok.Data;

/**
 * @program: 极度真实还原大麦网高并发实战项目。 添加 阿星不是程序员 微信，添加时备注 大麦 来获取项目的完整资料 
 * @description: 业务异常
 * @author: 阿星不是程序员
 **/
@Data
public class unieventsFrameException extends BaseException {

	private Integer code;
	
	private String message;

	public unieventsFrameException() {
		super();
	}

	public unieventsFrameException(String message) {
		super(message);
	}
	
	
	public unieventsFrameException(String code, String message) {
		super(message);
		this.code = Integer.parseInt(code);
		this.message = message;
	}
	
	public unieventsFrameException(Integer code, String message) {
		super(message);
		this.code = code;
		this.message = message;
	}
	
	public unieventsFrameException(BaseCode baseCode) {
		super(baseCode.getMsg());
		this.code = baseCode.getCode();
		this.message = baseCode.getMsg();
	}
	
	public unieventsFrameException(ApiResponse apiResponse) {
		super(apiResponse.getMessage());
		this.code = apiResponse.getCode();
		this.message = apiResponse.getMessage();
	}

	public unieventsFrameException(Throwable cause) {
		super(cause);
	}

	public unieventsFrameException(String message, Throwable cause) {
		super(message, cause);
		this.message = message;
	}

	public unieventsFrameException(Integer code, String message, Throwable cause) {
		super(message, cause);
		this.code = code;
		this.message = message;
	}
}
