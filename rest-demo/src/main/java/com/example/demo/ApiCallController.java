package com.example.demo;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class ApiCallController {
	
	@Autowired
	Scanner scan;
	
	@Autowired
	RestTemplate restTemplate;
	

	
	@GetMapping("/age/{name}")
	public String callApi(@PathVariable String name){
	
		
		String calledApi = restTemplate.getForObject("https://api.agify.io?name="+name, String.class);
		ObjectMapper objmap=new ObjectMapper();
		ReturnPerson rp=new ReturnPerson();
		
		try {
			Person p = objmap.readValue(calledApi,Person.class);
			rp.setName(p.getName());
			rp.setAge(p.getAge());
			rp.setCount(p.getCount());
			
			if(p.getAge()>18) {
				rp.setVoter(rp.getName()+" is eligible to vote");
				
			}
			else 
				rp.setVoter(rp.getName()+" is not eligible to vote");
			if(p.getCount()>50) {
				rp.setCommon(rp.getName()+ " is a common name");
				
			}
			else rp.setCommon(rp.getName()+ " is not a common name");
			
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String returnString="";
		try {
			returnString = objmap.writeValueAsString(rp);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	return returnString;
	}
}

class Person{
	@JsonProperty("name")
	String name;
	@JsonProperty("age")
	int age;
	@JsonProperty("count")
	int count;
	
	
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getAge() {
		return this.age;
	}
	
	public int getCount() {
		return this.count;
	}
	
	public String getName() {
		return this.name;
	}
}
class ReturnPerson extends Person{
	@JsonProperty("voter")
	private String voter;
	@JsonProperty("common")
	private String common;
	
	public void setVoter(String voter) {
		this.voter = voter;
	}
	public void setCommon(String common) {
		this.common = common;
	}
	
}

	

