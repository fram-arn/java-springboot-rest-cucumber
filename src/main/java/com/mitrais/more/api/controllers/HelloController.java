package com.mitrais.more.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@RequestMapping(value="/hello",method=RequestMethod.GET,produces="application/json")
	public String sayHelloToPerson() {
		return "Hallo";
	}
}
