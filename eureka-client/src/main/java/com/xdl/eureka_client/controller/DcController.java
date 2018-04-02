package com.xdl.eureka_client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DcController {
	 @Autowired
   DiscoveryClient discoveryClient;
	 
	 @GetMapping("/dc")
   public String dc() {
       String services = "Services: " + discoveryClient.getServices();
       System.out.println(services);
       return services;
   }
	 


   /**
    * 提供一个服务的方法 
    */
	 @GetMapping("hello")
	 public String hello(){
		 return "hello Word";
	 }

}
