package uk.co.raytheon;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import uk.co.raytheon.storage.StorageProperties;
import uk.co.raytheon.storage.StorageService;


@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class PicTestWebServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PicTestWebServerApplication.class, args);
	}
	
	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
            storageService.deleteAll();
            storageService.init();
		};
	}
}
