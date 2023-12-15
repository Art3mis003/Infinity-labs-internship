package com.usermanagement.model;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDeptInfo  implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String department;
private String reportingMgrName;
private String reportingMgrEmailString;
private String primaryDepartment;

}


