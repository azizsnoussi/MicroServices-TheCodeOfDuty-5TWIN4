package esprit.com.microservice.review.model;


import javax.persistence.*;



@Entity
@Table( name = "Review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String review;

    @Column(name = "rating", nullable = false)
    private int rating;

    @Column(name = "client_id", nullable = false)
    private int clientId;

    @Column(name = "project_id", nullable = false)
    private int projectId;



    public Review() {
    }

    public Review(int id, String review, int rating, int clientId , int projectId  ) {
        this.id = id;
        this.review = review;
        this.rating = rating;
        this.clientId = clientId;
        this.projectId = projectId;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setprojectId(int projectId) {
        this.projectId = projectId;
    }


}

