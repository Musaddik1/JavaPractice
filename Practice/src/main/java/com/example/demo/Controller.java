package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@CrossOrigin(origins = "* ",allowedHeaders = "{*}",originPatterns = "*")
public class Controller {

	
	
	@GetMapping("/data")
	public List<Details> getData(){
		
		List<Details> list=new ArrayList<>();
		Details d1=new Details(1,"Musaddik",true);
		Details d2=new Details(2,"Ahmed",false);
		Details d3=new Details(3,"Shaikh",true);
		Details d4=new Details(4,"Ishaque",false);
		list.add(d1);
		list.add(d2);
		list.add(d3);
		list.add(d4);
		return list;
		
	}
}
