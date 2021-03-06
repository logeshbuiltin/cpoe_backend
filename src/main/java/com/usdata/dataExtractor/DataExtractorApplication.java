package com.usdata.dataExtractor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@EnableJpaAuditing
@CrossOrigin(origins = "*")
public class DataExtractorApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataExtractorApplication.class, args);
	}

}
