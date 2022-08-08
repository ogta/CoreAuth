package com.otapp.coreauth.common.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

public class DTOToken extends DTOBase {
		
	@Getter @Setter
	private String token;
	
	@Getter @Setter
	private String tokenHash;
	
	@Getter @Setter
	private int tokenStatus;
	
	@Getter @Setter
	private LocalDateTime tokenCreateDate;
	
	@Getter @Setter
	private int tokenTimeout;
	
}
