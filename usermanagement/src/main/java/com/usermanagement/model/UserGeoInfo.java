package com.usermanagement.model;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserGeoInfo implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String jobLocation;
private String country;
private String baseLocation;

}
