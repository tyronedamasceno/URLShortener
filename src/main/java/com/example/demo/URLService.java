package com.example.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class URLService {
	
	@Autowired
	private URLRepository repository;
	
	private IDConverter converter = IDConverter.getInstance();
	
	public URL findByShortURL(String shortURL) {
		Optional<URL> obj = repository.findByShortURL(shortURL);
		return obj.orElse(null);
	}
	
	public URL insert(URL obj) {
		obj.setId(null);
		obj = repository.save(obj);
		obj.setShortURL(converter.toBase62(String.valueOf(obj.getId())));
		return repository.save(obj);
	}
	
}
