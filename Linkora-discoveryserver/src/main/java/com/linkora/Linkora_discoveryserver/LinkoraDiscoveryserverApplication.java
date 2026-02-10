package com.linkora.Linkora_discoveryserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class LinkoraDiscoveryserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(LinkoraDiscoveryserverApplication.class, args);
	}

}
