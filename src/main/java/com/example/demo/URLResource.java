package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShortenerResource {

	@RequestMapping(method=RequestMethod.GET)
	public String ok() {
		return "Ok!";
	}
	
}
