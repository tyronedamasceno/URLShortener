package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class URLResource {

	@Autowired
	private URLService service;
	
	@RequestMapping(value="/{shortURL}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable String shortURL) {
		URL obj = service.findByShortURL(shortURL);
		if (obj == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.ok(obj);
	}
	
}
