package kz.iitu.springlab.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication(scanBasePackages = "kz.iitu.springlab")
@ConfigurationPropertiesScan(basePackages = "kz.iitu.springlab.config")
public class SpringLab01Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringLab01Application.class, args);
	}
}