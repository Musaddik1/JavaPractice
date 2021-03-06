package com.example.login.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.login.model.Country;
import com.example.login.model.Login;
import com.example.login.model.Register;
import com.example.login.model.Swap;


public interface UserService{


	public String register(Register register);
	
	public String login(Login login);
	
	public List<Country> getCountry();
	
	public Country getCountryByName(String name);
	
	public String covertCurrency(String from,String to,double amount);
	
	public Swap getSwap(String from,String to);
}

