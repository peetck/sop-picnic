package com.microservices.servicediscovery.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.netflix.discovery.shared.Applications;
import com.netflix.eureka.EurekaServerContextHolder;
import com.netflix.eureka.registry.PeerAwareInstanceRegistry;

import java.util.*;

@RestController
public class DiscoveryService {
	
	String services[] = {"TEACHERSERVICE", "STUDENTSERVICE", "CLIENT3", "CLIENT4", "CLIENT5"};
	
	@RequestMapping("/services")
	public ResponseEntity<String> serviceInstancesByApplicationName() {
    	
    	List<Map<String, String>> available = new ArrayList<Map<String, String>>();
    	
    	PeerAwareInstanceRegistry registry = EurekaServerContextHolder.getInstance().getServerContext().getRegistry();
        Applications applications = registry.getApplications();
        
        applications.getRegisteredApplications().forEach((registeredApplication) -> {
            registeredApplication.getInstances().forEach((instance) -> {
            	Map<String, String> data = new HashMap<String, String>();
            	data.put("appName", instance.getAppName());
            	data.put("status", instance.getStatus() + "");
            	
            	available.add(data);
            	
            });
        });
        
        main: for (String service : services) {
        	for(Map<String, String> map : available) {
        		if (map.get("appName").equals(service)) {
        			continue main;
        		}
        	}
        	// not found
        	Map<String, String> data = new HashMap<String, String>();
        	data.put("appName", service);
        	data.put("status", "DOWN");
        	available.add(data);
        }
        
        return new ResponseEntity<String>(new Gson().toJson(available), HttpStatus.OK);
	}
}
