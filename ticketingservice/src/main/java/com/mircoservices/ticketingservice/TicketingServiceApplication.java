package com.mircoservices.ticketingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableRetry
public class TicketingServiceApplication {
/*
docker run -d -p 8761:8761 --name eureka-server my-eureka-server

docker run  -d -p 8081:8081 --name ticketing-service ticketing-service
docker run -d -p 8082:8082 --name inventory-system inventory-system
docker run -d -p 80:80 --name my-nginx-gateway my-nginx-gateway
create a docker-compose.yml  file
 */
	public static void main(String[] args) {
		SpringApplication.run(TicketingServiceApplication.class, args);
	}

}
