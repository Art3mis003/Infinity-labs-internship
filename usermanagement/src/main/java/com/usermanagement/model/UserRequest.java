package com.usermanagement.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private Date dob;
	private String bloodGroup;
	private String designation;
	private String gender;
	private List <UserContactInfo> userContactInfo;
	private List <UserDeptInfo> userDeptInfo;
	private List <UserGeoInfo> userGeoinfo;
	
}
