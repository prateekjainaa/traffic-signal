package com.globoforce.trafficsignal;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.globoforce.trafficsignal.service.TrafficSignalService;

@SpringBootApplication
public class TrafficSignalApplication {

	private static final Logger logger = Logger.getLogger(TrafficSignalApplication.class);
	
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(TrafficSignalApplication.class, args);
        TrafficSignalService trafficSignalService = (TrafficSignalService) context.getBean("trafficSignalService");
        int pauseDuration = 2000; // This can be fetched from DB.
        logger.info("\n\n--- Traffic signal --- \n");
        trafficSignalService.start(pauseDuration);
	}
}
