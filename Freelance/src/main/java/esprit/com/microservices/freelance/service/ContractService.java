package esprit.com.microservices.freelance.service;

import esprit.com.microservices.freelance.model.Contract;
import esprit.com.microservices.freelance.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContractService {

    @Autowired
    private ContractRepository contractRepository;

    public Contract addContract(Contract contract) {
        return contractRepository.save(contract);
    }
    public Contract updateContract(Contract newContract, int id) {
        if (contractRepository.findById(id).isPresent()) {
            Contract existingContract = contractRepository.findById(id).get();
            existingContract.setProjectId(newContract.getProjectId());
            existingContract.setFreelancerId(newContract.getFreelancerId());
            existingContract.setClientId(newContract.getClientId());
            existingContract.setProjectCost(newContract.getProjectCost());
            existingContract.setStatus(newContract.getStatus());
            existingContract.setCreatedAt(newContract.getCreatedAt());
            existingContract.setUpdatedAt(newContract.getUpdatedAt());
            return contractRepository.save(existingContract);
        } else {
            throw new IllegalArgumentException("Invalid contract");
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