package com.xdl.eureka_consumer;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Hello world!
 *
 */
@EnableDiscoveryClient
@SpringBootApplication
public class App 
{
	@LoadBalanced
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
    public static void main( String[] args )
    {
    	new SpringApplicationBuilder(App.class).web(true).run(args);
    }
    
    
}
