package com.esprit.microservices.freelance.controller;

import com.esprit.microservices.freelance.model.Task;
import com.esprit.microservices.freelance.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Task> createTask(@RequestBody Task task) {

        return new ResponseEntity<>(taskService.addTask(task), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Task> updateTask(@PathVariable(value = "id") int id,
                                               @RequestBody Task task) {

        return new ResponseEntity<>(taskService.updateTask((long) id, task), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteTask(@PathVariable(value = "id") int id) {
        // Assuming you have a method similar to deleteCandidat for tasks
        return new ResponseEntity<>(taskService.deleteTask((long) id), HttpStatus.OK);
    }
}
