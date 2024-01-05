package springboot.recipebook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@EnableJpaRepositories
@SpringBootApplication
@EnableJpaAuditing
public class RecipebookApplication2 {
	public static void main(String[] args) {
		SpringApplication.run(RecipebookApplication2.class, args);
	}
}
