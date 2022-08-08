package com.otapp.coreauth.service;

import java.time.LocalDateTime;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.otapp.coreauth.common.constant.RecordStatus;
import com.otapp.coreauth.common.constant.ResponseCode;
import com.otapp.coreauth.common.dao.DAOCoreAuthUser;
import com.otapp.coreauth.common.dto.DTOToken;
import com.otapp.coreauth.common.dto.DTOUser;
import com.otapp.coreauth.common.interfaces.dal.IDALCoreAuthUser;
import com.otapp.coreauth.common.interfaces.service.ITokenService;

@Service
public class TokenService implements ITokenService {

	@Autowired
	private IDALCoreAuthUser dalCoreAuthUser;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public DTOToken validateToken(DTOToken token) {
		
		DTOToken response = new DTOToken();
		
		DAOCoreAuthUser user = dalCoreAuthUser.findUserByToken(token.getToken());
		
		if (user.isSuccessResponse()) {
			if (user.getTokenStatus() == RecordStatus.ACTIVE.Code() && 
					LocalDateTime.now().isBefore(user.getTokenCreateDate().plusSeconds(user.getTokenTimeout()))) {
				return modelMapper.map(user, DTOUser.class);
			}
			response.setResponseCode(ResponseCode.TOKEN_EXPIRED.Code());
			response.setResponseDescription(ResponseCode.TOKEN_EXPIRED.Description());
			return response;
		} 
		
		response.setResponseCode(ResponseCode.TOKEN_EXPIRED.Code());
		response.setResponseDescription(ResponseCode.TOKEN_EXPIRED.Description());
		return response;
		
		
	}

}
