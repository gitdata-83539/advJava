package com.sunbeam.dto;

import javax.persistence.Column;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDto {
	
	private Long id;
	private String adrLine1;
	
	private String adrLine2;
	
	private String city;
		private String state;
	
	private String country;
		private String zipCode;
	
	private String phoneNo;
}
