
package kz.iitu.springlab.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "kz.iitu.springlab")
@EntityScan(basePackages = "kz.iitu.springlab.account")
@EnableJpaRepositories(basePackages = "kz.iitu.springlab.account")
public class SpringLab01Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringLab01Application.class, args);
	}
}
