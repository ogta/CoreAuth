package com.otapp.coreauth.common.interfaces.dal;

import com.otapp.coreauth.common.dao.DAOCoreAuthUser;

public interface IDALCoreAuthUser {

	DAOCoreAuthUser createUser(DAOCoreAuthUser user);

	DAOCoreAuthUser findUserByUsernameOrEmail(String username, String email);

	DAOCoreAuthUser findUserByToken(String token);

	DAOCoreAuthUser login(DAOCoreAuthUser user);

}
