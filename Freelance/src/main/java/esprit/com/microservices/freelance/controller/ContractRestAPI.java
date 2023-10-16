package esprit.com.microservices.freelance.controller;

import esprit.com.microservices.freelance.model.Contract;
import esprit.com.microservices.freelance.service.ContractService;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/contracts")
public class ContractRestAPI {

    @Autowired
    private ContractService contractService;


    @PostMapping(value = "/user")
    public ResponseEntity<Contract> createContract(@RequestBody Contract contract) {
        return new ResponseEntity<>(contractService.addContract(contract), HttpStatus.CREATED);
    }

    @PutMapping(value = "/user/{id}")
    public ResponseEntity<Contract> updateContract(@RequestBody Contract contract, @PathVariable(value = "id") int id) {
        return new ResponseEntity<>(contractService.updateContract(contract, id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteContract(@PathVariable(value = "id") int id, KeycloakAuthenticationToken authentication) {
        boolean hasAdminRole = authentication.getAccount().getKeycloakSecurityContext().getToken().getRealmAccess().isUserInRole("admin");

        if (hasAdminRole) {
            return new ResponseEntity<>(contractService.deleteContract(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping(value = "/user")
    public ResponseEntity<List<Contract>> getAllContracts() {
        List<Contract> contracts = contractService.getAllContracts();


        return new ResponseEntity<>(contracts, HttpStatus.OK);
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<Contract> getContractById(@PathVariable(value = "id") int id) {
        Optional<Contract> contract = contractService.getContractById(id);
        if (contract.isPresent()) {
            return new ResponseEntity<>(contract.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}