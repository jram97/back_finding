package com.finding.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoAuditing
@EnableMongoRepositories
public class FindingBackendApplication implements CommandLineRunner {

    @Autowired
    private Environment env;
	private static final Logger logger = LoggerFactory.getLogger(FindingBackendApplication.class);
        
    @Override
    public void run(String... args) throws Exception {
		logger.info("{}", env.getProperty("finding.app.environment"));
    }

    public static void main(String[] args) {
        SpringApplication.run(FindingBackendApplication.class, args);
    }
	
}
