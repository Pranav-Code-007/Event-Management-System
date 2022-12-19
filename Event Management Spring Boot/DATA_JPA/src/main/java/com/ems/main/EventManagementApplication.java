package com.ems.main;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

import com.ems.service.BookingService;

@EntityScan(basePackages="com.ems.model")
@EnableJpaRepositories(basePackages="com.ems.repository")
@SpringBootApplication(scanBasePackages="com.ems")
public class EventManagementApplication {

	static Logger logger=Logger.getLogger(EventManagementApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(EventManagementApplication.class, args);
		
		logger.setLevel(Level.INFO);
        logger.debug("Debug Message....");
        logger.info("Info Message....");
        logger.warn("Warn Message....");
        logger.error("Error Message....");
        logger.fatal("fatal Message....");

	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
}
