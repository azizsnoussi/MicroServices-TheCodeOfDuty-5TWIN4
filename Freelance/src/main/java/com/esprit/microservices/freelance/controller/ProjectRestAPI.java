package com.esprit.microservices.freelance.controller;


import com.esprit.microservices.freelance.model.Project;
import com.esprit.microservices.freelance.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/projects")
public class ProjectRestAPI {

    @Autowired
    private ProjectService projectService;

    @GetMapping
    public List<Project> getAllAdminProjects() {
        return projectService.getAllProjects();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Project getProjectById(@PathVariable(value = "id") int id) {
        Optional<Project> project = projectService.getProjectById(id);
        return project.orElse(null);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Project createProject(@RequestBody Project project) {
        return projectService.addProject(project);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Project updateProject(@RequestBody Project project, @PathVariable(value = "id") int id) {
        return projectService.updateProject(project, id);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public String deleteProject(@PathVariable(value = "id") int id) {
        return projectService.deleteProject(id);
    }

}