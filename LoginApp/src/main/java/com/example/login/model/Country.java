package com.example.login.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Country {

	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private long id;
	
	private String countrycode;
	
	private String countryname;
	
	private String code;
	
	private String url;
	
	public Country() {
		
		
		
	}

	public Country(long id, String countrycode, String countryname, String code, String url) {
		super();
		this.id = id;
		this.countrycode = countrycode;
		this.countryname = countryname;
		this.code = code;
		this.url = url;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCountrycode() {
		return countrycode;
	}

	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}

	public String getCountryname() {
		return countryname;
	}

	public void setCountryname(String countryname) {
		this.countryname = countryname;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}