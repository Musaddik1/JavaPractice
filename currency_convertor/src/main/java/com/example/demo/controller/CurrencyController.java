package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.CurrencyConverter;

@RestController
@RequestMapping("/v1")
public class CurrencyController {

	@Autowired
	private CurrencyConverter currencyConverter;
	
	@GetMapping("/currency")
	public String getCurrencyConverter(@RequestParam String from,@RequestParam String to,@RequestParam double amount) {
		
		
		return currencyConverter.covertCurrency(from, to, amount);
	}
}


