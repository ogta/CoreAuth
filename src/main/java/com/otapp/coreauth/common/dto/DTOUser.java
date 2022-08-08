package com.otapp.coreauth.common.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

public class DTOUser extends DTOToken {
	
	@Getter @Setter
	private String id;
	
	@Getter @Setter
	private String username;
	
	@Getter @Setter
	private String password;
	
	@Getter @Setter
	private String email;
	
	@Getter @Setter
	private LocalDateTime recordDate;
	
	@Getter @Setter
	private int status;
	
}
