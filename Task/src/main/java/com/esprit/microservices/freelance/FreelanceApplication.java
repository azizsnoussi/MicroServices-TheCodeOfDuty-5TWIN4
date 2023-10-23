package com.esprit.microservices.freelance;

import com.esprit.microservices.freelance.model.Task;
import com.esprit.microservices.freelance.repository.TaskRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import java.util.stream.Stream;

@SpringBootApplication
@EnableEurekaClient
public class FreelanceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FreelanceApplication.class, args);
    }

    @Bean
    ApplicationRunner init(TaskRepository repository) {
        return args -> {
            Stream.of("Task 1", "Task 2", "Task 3").forEach(title -> {
                Task task = new Task();
                task.setTitle(title);
                // Set other task attributes if needed
                repository.save(task);
            });
            repository.findAll().forEach(System.out::println);
        };
    }
}
