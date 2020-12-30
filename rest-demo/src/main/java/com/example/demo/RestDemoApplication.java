package com.example.demo;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RestDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestDemoApplication.class, args);
		
		}
	@Bean
	public Scanner scan() {
		return new Scanner(System.in);
	}
		
	@Bean 
	public RestTemplate restTemplate(){
		return new RestTemplate();
		
	
	}
		
}

