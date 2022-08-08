package com.otapp.coreauth.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.otapp.coreauth.common.dao.DAOCoreAuthUser;
import com.otapp.coreauth.common.dto.DTOUser;
import com.otapp.coreauth.common.interfaces.dal.IDALCoreAuthUser;
import com.otapp.coreauth.common.interfaces.service.IRegisterService;

@Service
public class RegisterService implements IRegisterService {

	@Autowired
	private IDALCoreAuthUser dalCoreAuthUser;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public DTOUser createUser(DTOUser user) {
		
		DAOCoreAuthUser userDao = dalCoreAuthUser.findUserByUsernameOrEmail(user.getUsername(), user.getEmail());
		
		if (userDao.isSuccessResponse()) {
			userDao = dalCoreAuthUser.createUser(modelMapper.map(user, DAOCoreAuthUser.class));
		}

		return modelMapper.map(userDao, DTOUser.class);

	}

}
