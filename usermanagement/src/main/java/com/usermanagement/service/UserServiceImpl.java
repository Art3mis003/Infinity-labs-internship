package com.usermanagement.service;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.usermanagement.entity.UserMaster;
import com.usermanagement.model.UserRequest;
import com.usermanagement.repository.IUserRepository;
@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	IUserRepository iUserRepository;

	@Override
	public UserMaster createUser(UserRequest userRequest) {
		// TODO Auto-generated method stub
		UserMaster userMaster= convertToUserMaster(userRequest);
		String userId= getUserId();
		userMaster.setUserId(userId);
		userMaster.setCreatedAt(new Date());
		userMaster.setStatus("Active");
		return iUserRepository.save(userMaster);
		

		
	}
	private UserMaster convertToUserMaster(UserRequest userRequest) {
	ObjectMapper mapper=new ObjectMapper();
	mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
	mapper.setSerializationInclusion(Include.NON_NULL);
	UserMaster userMaster = mapper.convertValue(userRequest, UserMaster.class);
//	userMaster.setCreatedAt(new Date());
		return userMaster;
}
	@Override
	public List<UserMaster> getAllUsers() {
		return iUserRepository.findAll();
	
	}
	/**
	 * 
	 * @return
	 */
	private String getUserId() {
		Random rand = new Random();
		String id = String.format("%04d", rand.nextInt(10000));
		return "U".concat(id);		
	}
	@Override
	public UserMaster getUserByUserId(String userId) {
		return iUserRepository.getUserByUserId(userId);
	}

	@Override
	public UserMaster getUserByEmail(String email) {
		return iUserRepository.getUserByEmail(email);
	}
	@Override
	public UserMaster updateUserByUserId(UserMaster userMaster) {
		UserMaster obj= iUserRepository.getUserByUserId(userMaster.getUserId());
		userMaster.set_id(obj.get_id());
		userMaster.setUpdatedAt(new Date());
		return iUserRepository.save(userMaster);
	
	}
	@Override
	public UserMaster deleteUserByUserId(String userId, String loggedInEmail) {
		UserMaster obj= iUserRepository.getUserByUserId(userId);
		obj.setStatus("deleted");
		obj.setUpdatedAt(new Date());
		obj.setUpdatedBy(loggedInEmail);
		return iUserRepository.save(obj);
		
	}

}
