package com.example.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class URLService {
	
	@Autowired
	private URLRepository repository;
	
	public URL findByShortURL(String shortURL) {
		Optional<URL> obj = repository.findByShortURL(shortURL);
		return obj.orElse(null);
	}
	
}
