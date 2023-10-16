package esprit.com.microservices.freelance;

import esprit.com.microservices.freelance.model.Project;
import esprit.com.microservices.freelance.repository.ProjectRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.stream.Stream;

@EnableEurekaClient
@SpringBootApplication
public class FreelanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FreelanceApplication.class, args);
	}
	@Bean
	ApplicationRunner init(ProjectRepository repository) {
		return args -> {
			Stream.of("title1", "title2", "title3").forEach(title -> {
				Project project = new Project();
				project.setTitle(title);
				project.setDescription("Sample description");
				project.setImage("sample.jpg");
				project.setClientId(1);
				project.setCost(BigDecimal.TEN);
				project.setStatus(Project.ProjectStatus.NOT_COMPLETED);
				project.setRequiredSkills("Java, Spring Boot");
				project.setCategory("Sample category");
				project.setCreatedAt(LocalDateTime.now());
				project.setUpdatedAt(LocalDateTime.now());
				repository.save(project);
			});
			repository.findAll().forEach(System.out::println);
		};
	}
}
