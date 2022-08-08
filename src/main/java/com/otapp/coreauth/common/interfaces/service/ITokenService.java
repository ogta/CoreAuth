package com.otapp.coreauth.common.interfaces.service;

import com.otapp.coreauth.common.dto.DTOToken;

public interface ITokenService {

	DTOToken validateToken(DTOToken token);

}
