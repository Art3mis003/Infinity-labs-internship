package com.usermanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.usermanagement.entity.UserMaster;
import com.usermanagement.model.UserRequest;
//@Service
public interface IUserService {
public UserMaster createUser(UserRequest userRequest); 
public List <UserMaster> getAllUsers();
public UserMaster getUserByUserId(String userId);
public UserMaster getUserByEmail(String email);
public UserMaster updateUserByUserId(UserMaster userMaster);
public UserMaster deleteUserByUserId(String userId, String loggedInEmail);


}
