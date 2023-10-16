package esprit.com.microservices.freelance.repository;


import esprit.com.microservices.freelance.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Integer> {

}
