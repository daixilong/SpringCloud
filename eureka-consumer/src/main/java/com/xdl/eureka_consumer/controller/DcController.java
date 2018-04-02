package com.xdl.eureka_consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DcController {

  @Autowired
  LoadBalancerClient loadBalancerClient;
  @Autowired
  RestTemplate restTemplate;
  
  @GetMapping("/consumer")
  public String dc() {
      ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-client");
      String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/dc";
      System.out.println(url);
      return restTemplate.getForObject(url, String.class);
  }
  /**
   * 消费一个服务
   */
  @GetMapping("/hello")
  public String hello(){
	  ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-client");
      String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/hello";
      return restTemplate.getForObject("http://eureka-client/hello", String.class);
  }
}
