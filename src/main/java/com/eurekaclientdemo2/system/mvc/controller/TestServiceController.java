package com.eurekaclientdemo2.system.mvc.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("test2")
public class TestServiceController {

	@Value("${eureka.instance.instance-id}")
	private String instanceId; // 注入application.properties的eureka.instance.instance-id的值

	@GetMapping(value = "/{message}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String getAllMessagesByMemberId(@PathVariable String message) throws JsonProcessingException {
		String messages = "finish call  {" + message + "} in test2 service , instance id : " + instanceId;
		return new ObjectMapper().writeValueAsString(messages);
	}

}
