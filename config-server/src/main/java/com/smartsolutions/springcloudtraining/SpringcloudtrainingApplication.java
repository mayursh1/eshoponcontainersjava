package com.smartsolutions.springcloudtraining;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringcloudtrainingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudtrainingApplication.class, args);
	}

}
