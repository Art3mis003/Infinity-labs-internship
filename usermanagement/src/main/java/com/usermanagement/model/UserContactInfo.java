package com.usermanagement.model;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserContactInfo implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String type;
private String countryCode;
private String mobileNumber;
private String emailId;
}
