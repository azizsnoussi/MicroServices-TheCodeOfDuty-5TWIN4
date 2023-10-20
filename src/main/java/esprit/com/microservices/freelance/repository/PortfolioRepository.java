package esprit.com.microservices.freelance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import esprit.com.microservices.freelance.model.Portfolio;

@Repository

public interface PortfolioRepository extends JpaRepository<Portfolio,Long>{


}
