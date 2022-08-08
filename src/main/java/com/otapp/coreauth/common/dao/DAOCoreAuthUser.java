package com.otapp.coreauth.common.dao;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.otapp.coreauth.common.constant.ResponseCode;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "coreauth_user")
public class DAOCoreAuthUser extends DAOBase {

	@Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",strategy = "org.hibernate.id.UUIDGenerator")
	@Getter @Setter
    private UUID id;
	
	@Getter @Setter
	private String username;
	
	@Getter @Setter
	private String password;
	
	@Getter @Setter
	private String email;
	
	@Getter @Setter
	private String token;
	
	@Getter @Setter
	private String tokenHash;
	
	@Getter @Setter
	private int tokenStatus;
	
	@Getter @Setter
	private LocalDateTime tokenCreateDate;
	
	@Getter @Setter
	private LocalDateTime recordDate;
	
	@Getter @Setter
	private int status;
	
	@Getter @Setter
	private int tokenTimeout;
	
}
