package com.example.demo.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
 @RequestMapping("/helo/{name}")
	public String hello(@PathVariable String name) 
	{
		return"hello"+name;
	}
}
