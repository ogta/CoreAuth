package com.otapp.coreauth.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.otapp.coreauth.common.dto.DTOUser;
import com.otapp.coreauth.common.interfaces.service.IRegisterService;

@RestController
@RequestMapping("/api/register")
public class RegisterController {

	@Autowired
	private IRegisterService registerService;

	@PostMapping("/")
	public ResponseEntity<DTOUser> registerUser(@Validated @RequestBody DTOUser user) {
		
		return new ResponseEntity<DTOUser>(registerService.createUser(user), HttpStatus.CREATED);
		
	}

}
