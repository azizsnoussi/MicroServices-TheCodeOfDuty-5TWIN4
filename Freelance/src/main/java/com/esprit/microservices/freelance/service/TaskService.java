package com.esprit.microservices.freelance.service;

import com.esprit.microservices.freelance.model.Task;
import com.esprit.microservices.freelance.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository; // You should have a TaskRepository or a similar repository for tasks

    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateTask(Long id, Task newTask) {
        if (taskRepository.findById(id).isPresent()) {
            Task existingTask = taskRepository.findById(id).get();
            existingTask.setTitle(newTask.getTitle());
            existingTask.setDescription(newTask.getDescription());

            return taskRepository.save(existingTask);
        } else {
            return null; // Handle non-existent tasks as needed
        }
    }

    public String deleteTask(Long id) {
        if (taskRepository.findById(id).isPresent()) {
            taskRepository.deleteById(id);
            return "Task deleted";
        } else {
            return "Task not found"; // Handle non-existent tasks as needed
        }
    }
}
