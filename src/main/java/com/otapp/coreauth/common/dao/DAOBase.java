package com.otapp.coreauth.common.dao;

import com.otapp.coreauth.common.constant.ResponseCode;

import lombok.Getter;
import lombok.Setter;

public class DAOBase {
	
	@Getter @Setter
	private String responseCode = ResponseCode.SUCCESS.Code();
	
	@Getter @Setter
	private String responseDescription = ResponseCode.SUCCESS.Description();
	
	public Boolean isSuccessResponse() {
		return ResponseCode.SUCCESS.Code().equals(responseCode);
	}
}
