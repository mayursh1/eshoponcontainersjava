package com.smartsolutions.eshoponcontainersjava.catalogservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
@EnableDiscoveryClient
@EnableCaching
public class CatalogserviceApplication {


	public static void main(String[] args) {
		SpringApplication.run(CatalogserviceApplication.class, args);
	}

}
