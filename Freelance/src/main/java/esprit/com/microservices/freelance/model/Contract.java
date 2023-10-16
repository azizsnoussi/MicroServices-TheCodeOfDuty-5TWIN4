package esprit.com.microservices.freelance.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "contracts")
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    @Column(name = "freelancerId", nullable = false)
    private int freelancerId;

    @Column(name = "client_id", nullable = false)
    private int clientId;

    @Column(precision = 8, scale = 2)
    private BigDecimal projectCost;

    @Enumerated(EnumType.STRING)
    private ContractStatus status = ContractStatus.PENDING;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    public Contract() {
    }

    public Contract(Long id, Project project, int freelancerId, int clientId, BigDecimal projectCost, ContractStatus status, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.project = project;
        this.freelancerId = freelancerId;
        this.clientId = clientId;
        this.projectCost = projectCost;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public int getFreelancerId() {
        return freelancerId;
    }

    public void setFreelancerId(int freelancerId) {
        this.freelancerId = freelancerId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public BigDecimal getProjectCost() {
        return projectCost;
    }

    public void setProjectCost(BigDecimal projectCost) {
        this.projectCost = projectCost;
    }

    public ContractStatus getStatus() {
        return status;
    }

    public void setStatus(ContractStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public enum ContractStatus {
        PENDING,
        ACCEPTED,
        REJECTED
    }
}
