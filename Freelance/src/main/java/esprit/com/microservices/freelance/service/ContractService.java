package esprit.com.microservices.freelance.service;

import esprit.com.microservices.freelance.model.Contract;
import esprit.com.microservices.freelance.model.Project;
import esprit.com.microservices.freelance.repository.ContractRepository;
import esprit.com.microservices.freelance.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContractService {

    @Autowired
    private ContractRepository contractRepository;

    @Autowired
    private ProjectRepository projectRepository;

    public Contract addContract(Contract contract) {
        int projectId = contract.getProject().getId();
        Optional<Project> projectOptional = projectRepository.findById(projectId);

        if (projectOptional.isPresent()) {
            Project project = projectOptional.get();
            contract.setProject(project);
            return contractRepository.save(contract);
        } else {
            throw new IllegalArgumentException("Invalid project ID");
        }
    }
    public Contract updateContract(Contract newContract, int id) {
        if (contractRepository.findById(id).isPresent()) {
            Contract existingContract = contractRepository.findById(id).get();
            existingContract.setProject(newContract.getProject());
            existingContract.setFreelancerId(newContract.getFreelancerId());
            existingContract.setClientId(newContract.getClientId());
            existingContract.setProjectCost(newContract.getProjectCost());
            existingContract.setStatus(newContract.getStatus());
            existingContract.setCreatedAt(newContract.getCreatedAt());
            existingContract.setUpdatedAt(newContract.getUpdatedAt());
            return contractRepository.save(existingContract);
        } else {
            return null;
        }
    }

    public String deleteContract(int id) {
        if (contractRepository.findById(id).isPresent()) {
            contractRepository.deleteById(id);
            return "Contract deleted";
        } else {
            return "Contract not found";
        }
    }

    public List<Contract> getAllContracts() {
        return contractRepository.findAll();
    }

    public Optional<Contract> getContractById(int id) {
        return contractRepository.findById(id);
    }

}