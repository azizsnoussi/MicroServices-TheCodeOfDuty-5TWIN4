package esprit.com.microservice.review.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import esprit.com.microservice.review.model.Review;


@Repository
public interface ReviewRepository extends JpaRepository<Review,Integer> {

}
