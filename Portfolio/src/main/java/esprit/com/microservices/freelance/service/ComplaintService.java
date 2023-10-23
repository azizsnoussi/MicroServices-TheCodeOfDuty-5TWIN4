package esprit.com.microservices.freelance.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import esprit.com.microservices.freelance.model.Complaint;
import esprit.com.microservices.freelance.repository.ComplaintRepository;

import java.util.List;

@Service
public class ComplaintService {

    private final ComplaintRepository complaintRepository;

    @Autowired
    public ComplaintService(ComplaintRepository complaintRepository) {
        this.complaintRepository = complaintRepository;
    }

    public Complaint createComplaint(Complaint complaint) {
        return complaintRepository.save(complaint);
    }

    public List<Complaint> getAllComplaints() {
        return complaintRepository.findAll();
    }

    public Complaint getComplaintById(Long id) {
        return complaintRepository.findById(id).orElse(null);
    }

    public Complaint updateComplaint(Long id, Complaint complaint) {
        if (complaintRepository.existsById(id)) {
            complaint.setId(id);
            return complaintRepository.save(complaint);
        }
        return null; // The complaint with this ID doesn't exist
    }

    public boolean deleteComplaint(Long id) {
        if (complaintRepository.existsById(id)) {
            complaintRepository.deleteById(id);
            return true;
        }
        return false; // The complaint with this ID doesn't exist
    }
}

