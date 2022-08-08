package com.otapp.coreauth.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.otapp.coreauth.common.dto.DTOToken;
import com.otapp.coreauth.common.interfaces.service.ITokenService;

@RestController
@RequestMapping("/api/token")
public class TokenController {

	@Autowired
	private ITokenService tokenService;

	@PostMapping("/validate")
	public ResponseEntity<DTOToken> login(@Validated @RequestBody DTOToken token) {
		return new ResponseEntity<DTOToken>(tokenService.validateToken(token), HttpStatus.OK);
	}

}
