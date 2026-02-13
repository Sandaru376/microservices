//package com.springbootacademy.employee_service;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.loadbalancer.LoadBalanced;
//import org.springframework.context.annotation.Bean;
//import org.springframework.web.reactive.function.client.WebClient;
//
//@SpringBootApplication
//@EnableFeignClient
//public class EmployeeServiceApplication {
//
//	public static void main(String[] args) {
//		SpringApplication.run(EmployeeServiceApplication.class, args);
//	}
//
////	@Bean
////	@LoadBalanced
////	public WebClient webClient(){
////		return WebClient.builder().build();
////	}
//}

package com.springbootacademy.employee_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EmployeeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

}