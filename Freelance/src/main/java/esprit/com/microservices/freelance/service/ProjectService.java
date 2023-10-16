package esprit.com.microservices.freelance.service;

import esprit.com.microservices.freelance.model.Project;
import esprit.com.microservices.freelance.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project addProject(Project project) {
        return projectRepository.save(project);
    }

    public Project updateProject(Project newProject, int id) {
        if (projectRepository.findById(id).isPresent()) {
            Project existingProject = projectRepository.findById(id).get();
            // Update existingProject properties with newProject properties
            // ...
            return projectRepository.save(existingProject);
        } else {
            return null;
        }
    }

    public String deleteProject(int id) {
        if (projectRepository.findById(id).isPresent()) {
            projectRepository.deleteById(id);
            return "Project deleted";
        } else {
            return "Project not found";
        }
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Optional<Project> getProjectById(int id) {
        return projectRepository.findById(id);
    }
}