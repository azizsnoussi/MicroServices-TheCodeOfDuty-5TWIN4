package esprit.com.microservice.review.controller;

import esprit.com.microservice.review.Service.ReviewService;
import esprit.com.microservice.review.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/review")
public class ReviewRestAPI {

    @Autowired
    private ReviewService reviewService;


    @PostMapping("/addReview")
    public ResponseEntity<Review> createReview(@RequestBody Review review) {
        return new ResponseEntity<>(reviewService.addReview(review), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Review> updateProject(@RequestBody Review review, @PathVariable(value = "id") int id) {
        return new ResponseEntity<>(reviewService.updateReview(review, id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews() {
        List<Review> reviews = reviewService.getAllReviews();
        if (reviews.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteReview(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(reviewService.deleteReview(id), HttpStatus.OK);
    }
}

