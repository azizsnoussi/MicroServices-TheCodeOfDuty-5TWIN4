package com.esprit.microservices.tasks.controllers;

import com.esprit.microservices.tasks.model.Task;
import com.esprit.microservices.tasks.services.TaskService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/tasks")
public class TasksRestAPI {
    private String title = "Hello, I'm the task Microservice";

    @Autowired
    private TaskService taskService; // You should have a TaskService or a similar service for tasks

    @RequestMapping("/hello")
    public String sayHello() {
        System.out.println(title);
        return title;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        // Assuming you have a method similar to addCandidat for tasks
        return new ResponseEntity<>(taskService.addTask(task), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Task> updateTask(@PathVariable(value = "id") int id,
                                           @RequestBody Task task) {
        // Assuming you have a method similar to updateCandidat for tasks
        return new ResponseEntity<>(taskService.updateTask((long) id, task), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteTask(@PathVariable(value = "id") int id) {
        // Assuming you have a method similar to deleteCandidat for tasks
        return new ResponseEntity<>(taskService.deleteTask((long) id), HttpStatus.OK);
    }
}
