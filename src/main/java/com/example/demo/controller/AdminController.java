package com.example.demo.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
	@RequestMapping("/admin/{name}")
	public String name(@PathVariable String name) {
		return "hello"+name;
	}

}
