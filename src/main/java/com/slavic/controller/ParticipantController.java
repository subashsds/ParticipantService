package com.slavic.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.slavic.dto.Response;
import com.slavic.dto.req.Login;
import com.slavic.service.impl.ParticipantService;

@RestController
@RequestMapping("/Participant")
public class ParticipantController {
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	ParticipantService participantService;
	
	private  final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping(value="/participant_details")
	public String method2() {
		LOG.info("Inside method2");
		String baseUrl = "http://localhost:8082/microservice3";
		String response=(String) restTemplate.exchange(baseUrl,
				HttpMethod.GET, null,String.class).getBody();
		LOG.info("The response recieved by method2 is "+ response);
		return response;
	}
	
	@PostMapping("/login")
	public @ResponseBody Response<?> login(@RequestBody Login login){		
		return participantService.login(login);
	}
	

}
