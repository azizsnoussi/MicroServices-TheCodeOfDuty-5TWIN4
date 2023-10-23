package esprit.com.microservices.freelance.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import esprit.com.microservices.freelance.model.Complaint;


@Repository

public interface ComplaintRepository extends JpaRepository<Complaint, Long> {
}
