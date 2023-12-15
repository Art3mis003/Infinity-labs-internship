package com.usermanagement.entity;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.usermanagement.model.UserContactInfo;
import com.usermanagement.model.UserDeptInfo;
import com.usermanagement.model.UserGeoInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "UserMaster")
public class UserMaster {
private String _id;
private String userId;
private String name;
private Date dob;
private List <UserContactInfo> userContactInfo;
private String bloodGroup;
private String designation;
private String gender;
private String status;
private Date createdAt;
private Date updatedAt;
private String createdBy;
private String updatedBy; 
private List <UserGeoInfo> userGeoinfo;
private List <UserDeptInfo> userDeptInfo;

}

