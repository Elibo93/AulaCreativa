package es.etg.daw.dawes.java.rest.aulaCreativa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
    scanBasePackages = "es.etg.daw.dawes.java.rest.aulaCreativa"
)
public class AulaCreativaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AulaCreativaApplication.class, args);
	}

}
