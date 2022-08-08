package com.otapp.coreauth.common.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.otapp.coreauth.common.dao.DAOCoreAuthUser;

@Repository
public interface ICoreAuthUserRepository extends CrudRepository<DAOCoreAuthUser, UUID> {

	DAOCoreAuthUser findByUsernameOrEmail(String username, String email);

	DAOCoreAuthUser findUserByPassword_AndUsernameOrEmail(String password, String username, String email);

	DAOCoreAuthUser findByToken(String token);

}
