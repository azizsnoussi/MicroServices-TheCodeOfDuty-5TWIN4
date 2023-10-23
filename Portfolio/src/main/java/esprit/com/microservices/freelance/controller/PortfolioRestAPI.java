package esprit.com.microservices.freelance.controller;

import esprit.com.microservices.freelance.model.Portfolio;
import esprit.com.microservices.freelance.service.PortfolioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/portfolios")
public class PortfolioRestAPI {

    private final PortfolioService portfolioService;

    @Autowired
    public PortfolioRestAPI(PortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }

    // Endpoint pour créer un nouveau portfolio
    @PostMapping
    public ResponseEntity<Portfolio> createPortfolio(@RequestBody Portfolio portfolio) {
        Portfolio createdPortfolio = portfolioService.createPortfolio(portfolio);
        return ResponseEntity.ok(createdPortfolio);
    }

    // Endpoint pour récupérer tous les portfolios
    @GetMapping
    public ResponseEntity<List<Portfolio>> getAllPortfolios() {
        List<Portfolio> portfolios = portfolioService.getAllPortfolios();
        return ResponseEntity.ok(portfolios);
    }

    // Endpoint pour récupérer un portfolio par ID
    @GetMapping("/{id}")
    public ResponseEntity<Portfolio> getPortfolioById(@PathVariable Long id) {
        Portfolio portfolio = portfolioService.getPortfolioById(id);
        if (portfolio == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(portfolio);
    }

    // Endpoint pour mettre à jour un portfolio
    @PutMapping("/{id}")
    public ResponseEntity<Portfolio> updatePortfolio(@PathVariable Long id, @RequestBody Portfolio portfolio) {
        Portfolio updatedPortfolio = portfolioService.updatePortfolio(id, portfolio);
        if (updatedPortfolio == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedPortfolio);
    }

    // Endpoint pour supprimer un portfolio par ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePortfolio(@PathVariable Long id) {
        if (portfolioService.deletePortfolio(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
