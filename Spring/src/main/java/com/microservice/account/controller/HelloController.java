package com.microservice.account.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/api/hello")
	public String sayHello() {
		return "Hello Rest API" ;
	}
}
/*
 * -- Make this a rest controller @RestController
 * -- Connect this method to API call.
 */