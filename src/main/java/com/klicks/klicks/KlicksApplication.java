package com.klicks.klicks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.klicks.klicks.property.FileStorageProperties;

@SpringBootApplication
@EnableConfigurationProperties({ FileStorageProperties.class })
public class KlicksApplication {

	public static void main(String[] args) {
		SpringApplication.run(KlicksApplication.class, args);
	}

}
