package com.example.login.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.login.model.Contact;
import com.example.login.model.Country;
import com.example.login.model.Login;
import com.example.login.model.Register;
import com.example.login.model.Swap;
import com.example.login.response.Response;
import com.example.login.service.UserService;

@RestController
@RequestMapping("/appservice")
@CrossOrigin("http://localhost:4200")
//@CrossOrigin(origins = "{*}",originPatterns = "{*}" ,allowedHeaders = "{*}")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<Response> register(@RequestBody Register register){
		
		String message=userService.register(register);
		if(message.contains("successfull")) {
			Response response=new Response(HttpStatus.OK.value(), message, null);
			return new ResponseEntity<Response>(response,HttpStatus.OK);
		}else {
			
			Response response=new Response(201, message, null);
			return new ResponseEntity<Response>(response,HttpStatus.BAD_GATEWAY);
		}
	}
	
	@PostMapping("/login")
	public ResponseEntity<Response> login(@RequestBody Login login){
		
		String message=userService.login(login);
		if(message.contains("successfull")) {
			Response response=new Response(HttpStatus.OK.value(),message,null);
			return new ResponseEntity<Response>(response,HttpStatus.OK);
		}else {
			Response response=new Response(201,message,null);
		
			return new ResponseEntity<Response>(response,HttpStatus.OK);
		}
	}
	
	@GetMapping("/country")
	public List<Country> getCountry(){
		
		System.out.println("Hello world");
		return userService.getCountry();
	}
	
	@GetMapping("/name")
	public Country getCountryByName(@RequestParam String name) {
		return  userService.getCountryByName(name);
	}
	
	@GetMapping("/currency")
	public String getCurrencyConverter(@RequestParam String from,@RequestParam String to,@RequestParam double amount) {
		
		
		return userService.covertCurrency(from, to, amount);
	}
	
	
	@GetMapping("/swap")
	public Swap getSwap(@RequestParam String from,@RequestParam String to) {
		
		return userService.getSwap(from, to);
	}
	
	@GetMapping("/contact")
	public List<Contact> getContact(){
		
		List<Contact> contacts=new ArrayList<Contact>();
		contacts.add(new Contact("9823139449", "Musaddik"));
		contacts.add(new Contact("8055981918", "Nadeem"));
		contacts.add(new Contact("8657913355", "ishtiyak"));
		
		return contacts;
	}
}
