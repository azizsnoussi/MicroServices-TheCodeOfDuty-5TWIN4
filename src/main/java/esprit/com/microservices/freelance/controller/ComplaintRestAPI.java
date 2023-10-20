package esprit.com.microservices.freelance.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import esprit.com.microservices.freelance.model.Complaint;
import esprit.com.microservices.freelance.service.ComplaintService;

import java.util.List;

@RestController
@RequestMapping("/api/complaints")
public class ComplaintRestAPI  {

    private final ComplaintService complaintService;

    @Autowired
    public ComplaintRestAPI(ComplaintService complaintService) {
        this.complaintService = complaintService;
    }

    @PostMapping
    public ResponseEntity<Complaint> createComplaint(@RequestBody Complaint complaint) {
        Complaint createdComplaint = complaintService.createComplaint(complaint);
        return ResponseEntity.ok(createdComplaint);
    }

    @GetMapping
    public List<Complaint> getAllComplaints() {
        List<Complaint> complaints = complaintService.getAllComplaints();
        return complaints;
    }


    @GetMapping("/{id}")
    public ResponseEntity<Complaint> getComplaintById(@PathVariable Long id) {
        Complaint complaint = complaintService.getComplaintById(id);
        if (complaint == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(complaint);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Complaint> updateComplaint(@PathVariable Long id, @RequestBody Complaint complaint) {
        Complaint updatedComplaint = complaintService.updateComplaint(id, complaint);
        if (updatedComplaint == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedComplaint);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComplaint(@PathVariable Long id) {
        if (complaintService.deleteComplaint(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
