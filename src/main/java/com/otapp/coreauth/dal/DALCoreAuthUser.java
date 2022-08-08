package com.otapp.coreauth.dal;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.otapp.coreauth.common.constant.RecordStatus;
import com.otapp.coreauth.common.constant.ResponseCode;
import com.otapp.coreauth.common.constant.TokenConstant;
import com.otapp.coreauth.common.dao.DAOCoreAuthUser;
import com.otapp.coreauth.common.interfaces.dal.IDALCoreAuthUser;
import com.otapp.coreauth.common.repository.ICoreAuthUserRepository;

@Component
public class DALCoreAuthUser implements IDALCoreAuthUser {

	@Autowired
	private ICoreAuthUserRepository userRepository;
	
	private void populateToken(DAOCoreAuthUser user) {
		user.setToken(UUID.randomUUID().toString());
		user.setTokenCreateDate(LocalDateTime.now());
		user.setTokenTimeout(TokenConstant.TOKEN_TIMEOUT);
		user.setTokenStatus(RecordStatus.ACTIVE.Code());
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(user.getToken().getBytes(StandardCharsets.UTF_8));
			String encoded = Base64.getEncoder().encodeToString(hash);
			user.setTokenHash(encoded);
		} catch (NoSuchAlgorithmException e) {
			user.setResponseCode(ResponseCode.BUSINESS_FAILED_ALGORITHM_NOT_FOUND.Code());
			user.setResponseDescription(ResponseCode.BUSINESS_FAILED_ALGORITHM_NOT_FOUND.Description());
		}
	}


	@Override
	public DAOCoreAuthUser createUser(DAOCoreAuthUser user) {

		user.setRecordDate(LocalDateTime.now());
		user.setStatus(RecordStatus.ACTIVE.Code());
		populateToken(user);

		user = userRepository.save(user);
		user.setPassword(null);
		return user;

	}

	@Override
	public DAOCoreAuthUser findUserByUsernameOrEmail(String username, String email) {
		DAOCoreAuthUser existUser = userRepository.findByUsernameOrEmail(username, email);
		if (null != existUser) {
			existUser = new DAOCoreAuthUser();
			existUser.setResponseCode(ResponseCode.USERNAME_ALREADY_EXIST.Code());
			existUser.setResponseDescription(ResponseCode.USERNAME_ALREADY_EXIST.Description());
			return existUser;
		}

		existUser = new DAOCoreAuthUser();
		return existUser;
	}

	@Override
	public DAOCoreAuthUser login(DAOCoreAuthUser user) {
		DAOCoreAuthUser existUser = userRepository.findUserByPassword_AndUsernameOrEmail(user.getPassword(),
				user.getUsername(), user.getEmail());
		if (null == existUser) {
			existUser = new DAOCoreAuthUser();
			existUser.setResponseCode(ResponseCode.USER_NOT_FOUND.Code());
			existUser.setResponseDescription(ResponseCode.USER_NOT_FOUND.Description());
			return existUser;
		}
		
		populateToken(existUser);
		
		existUser = userRepository.save(existUser);
		existUser.setPassword(null);
		return existUser;
	}


	@Override
	public DAOCoreAuthUser findUserByToken(String token) {
		DAOCoreAuthUser existUser = userRepository.findByToken(token);
		
		if (null == existUser) {
			existUser = new DAOCoreAuthUser();
			existUser.setResponseCode(ResponseCode.USER_NOT_FOUND.Code());
			existUser.setResponseDescription(ResponseCode.USER_NOT_FOUND.Description());
			return existUser;
		}
		
		existUser.setPassword(null);
		return existUser;
	}

}
