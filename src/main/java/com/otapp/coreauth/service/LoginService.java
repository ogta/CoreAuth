package com.otapp.coreauth.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.otapp.coreauth.common.dao.DAOCoreAuthUser;
import com.otapp.coreauth.common.dto.DTOUser;
import com.otapp.coreauth.common.interfaces.dal.IDALCoreAuthUser;
import com.otapp.coreauth.common.interfaces.service.ILoginService;

@Service
public class LoginService implements ILoginService {

	@Autowired
	private IDALCoreAuthUser dalCoreAuthUser;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public DTOUser login(DTOUser user) {

		DAOCoreAuthUser userDao = dalCoreAuthUser.login(modelMapper.map(user, DAOCoreAuthUser.class));

		return modelMapper.map(userDao, DTOUser.class);

	}

}
