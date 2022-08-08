package com.otapp.coreauth.common.dto;

import com.otapp.coreauth.common.constant.ResponseCode;

import lombok.Getter;
import lombok.Setter;

public class DTOBase {
	
	@Getter @Setter
	private String responseCode = ResponseCode.SUCCESS.Code();
	
	@Getter @Setter
	private String responseDescription = ResponseCode.SUCCESS.Description();
	
	public Boolean isSuccess() {
		return ResponseCode.SUCCESS.Code().equals(responseCode);
	}
}
