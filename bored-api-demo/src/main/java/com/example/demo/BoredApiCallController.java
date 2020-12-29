package com.example.demo;

import java.sql.ResultSet;

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
public class BoredApiCallController {
	
	
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/bored/{number}")
	public String callBoredApi(@PathVariable String number) {
		String returnData = new String();
		String callBoredApi = "";
		int i;
		for(i=1;i<=Integer.parseInt(number);++i)
		{
			callBoredApi = restTemplate.getForObject("https://www.boredapi.com/api/activity?participants="+number, String.class);
			returnData += callBoredApi;
		}
		return returnData;
//		ObjectMapper objmap=new ObjectMapper();
	}
	
	
	
}
class Activity{
	private int participants;
	private String type;
} 