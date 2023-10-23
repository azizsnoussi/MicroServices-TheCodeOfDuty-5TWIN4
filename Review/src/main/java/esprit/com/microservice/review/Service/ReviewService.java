package esprit.com.microservice.review.Service;

import esprit.com.microservice.review.Repository.ReviewRepository;
import esprit.com.microservice.review.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public Review addReview(Review review) {

        return reviewRepository.save(review);
    }

    public Review updateReview(Review newReview, int id) {

        if (reviewRepository.findById(id).isPresent()) {

            Review existingReview = reviewRepository.findById(id).get();
            existingReview.setprojectId(newReview.getProjectId());
            existingReview.setClientId(newReview.getClientId());
            existingReview.setRating(newReview.getRating());
            existingReview.setReview(newReview.getReview());

            return reviewRepository.save(existingReview);
        } else {
            return null;
        }
    }

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public String deleteReview(int id) {
        if (reviewRepository.findById(id).isPresent()) {
            reviewRepository.deleteById(id);
            return "Review deleted";
        } else {
            return "Review not found";
        }
    }
}

