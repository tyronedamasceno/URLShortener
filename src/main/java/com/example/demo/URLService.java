package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class URLService {
	
	private URLRepository repository;
	
	public URL findByShortURL(String shortURL) {
		URL obj = repository.findByShortURL(shortURL);
		return obj;
	}
	
}
