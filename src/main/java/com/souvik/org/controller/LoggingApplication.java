package com.souvik.org.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/logApplication")
public class LoggingApplication {
	private static final Logger logger = LoggerFactory.getLogger(LoggingApplication.class);
	
	@RequestMapping(value="/checkLogs/{name}", method = RequestMethod.GET)
	public String checkLogs(@PathVariable String name) {
		logger.info("path varaible name {}", name);
		logger.debug("this will print when debug enabled {}", name);
		
		String response = "Hi " + name ;
		
		if(name.equalsIgnoreCase("test")) {
			logger.error("this {} is not allowed", name);
			throw new RuntimeException("this is not allowed");
		}
		
		if(name.equalsIgnoreCase("testing")) {
			logger.warn("Return response {}", response);
		}
		
		logger.info("the response {}", response);
		
		return response;
	}

}
