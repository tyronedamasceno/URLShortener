package com.example.demo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UrlShortenerApplication implements CommandLineRunner{

	@Autowired
	private URLRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(UrlShortenerApplication.class, args);	
	}

	@Override
	public void run(String... args) throws Exception {
		URL url1 = new URL(null, "www.facebook.com", "00001");
		URL url2 = new URL(null, "www.youtube.com", "00002");
		
		repository.saveAll(Arrays.asList(url1, url2));
	}
}
