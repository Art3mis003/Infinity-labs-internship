package com.usermanagement.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.usermanagement.entity.UserMaster;
import com.usermanagement.model.UserRequest;
import com.usermanagement.service.IUserService;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/userService")
public class UserManagementController {

    @Autowired
    private IUserService userService;

    @PostMapping(path = "/createUser")
    public ResponseEntity<UserMaster> createUser(@RequestBody UserRequest userRequest) {
        UserMaster createdUser = userService.createUser(userRequest);
        return new ResponseEntity<>(createdUser, HttpStatus.OK);
    }
    @GetMapping(path = "/getAllUsers")
    public List <UserMaster> getAllUsers() {
    	return userService.getAllUsers();
    }
    @GetMapping(path = "/getUserById")
    public  UserMaster getUserByUserId(String userId) {
    	return userService.getUserByUserId(userId);
    }
    @GetMapping(path = "/getUserByEmail")
    public  UserMaster getUserByEmail(String email) {
    	UserMaster um= userService.getUserByEmail(email);
    	return um ;
    }
    @PostMapping(path = "/updateUser")
    public ResponseEntity<UserMaster> updateUser(@RequestBody UserMaster userMaster){
    	 UserMaster updatedUser = userService.updateUserByUserId(userMaster);
         return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }
    @DeleteMapping(path="/deleteUserByUserId")
    public  UserMaster deleteUserByUserId(@RequestParam String userId, HttpServletRequest httpServeletRequest) {
    	String loggedInEmail=httpServeletRequest.getHeader("x-auth-email");
    	return userService.deleteUserByUserId(userId,loggedInEmail);
    }

}
