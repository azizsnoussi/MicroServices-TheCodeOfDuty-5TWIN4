package com.esprit.microservices.tasks;

import com.esprit.microservices.tasks.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;
import com.esprit.microservices.tasks.model.Task;
@SpringBootApplication
@EnableEurekaClient
public class TasksApplication {


    public static void main(String[] args) {
        SpringApplication.run(TasksApplication.class, args);
    }
    @Autowired
    private TaskRepository taskRepository;
    @Bean
    ApplicationRunner init(TaskRepository repository) {
        return args -> {
            Stream.of("Task 1", "Task 2", "Task 3").forEach(title -> {
                Task task = new Task();
                task.setTitle(title);
                // Set other task attributes if needed
                taskRepository.save(task);
            });
            taskRepository.findAll().forEach(System.out::println);
        };
    }
}
