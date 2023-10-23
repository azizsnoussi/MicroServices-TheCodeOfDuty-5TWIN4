package esprit.com.microservices.freelance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import esprit.com.microservices.freelance.model.Portfolio;
import esprit.com.microservices.freelance.repository.PortfolioRepository;

import java.util.List;

@Service
public class PortfolioService {

    private final PortfolioRepository portfolioRepository;

    @Autowired
    public PortfolioService(PortfolioRepository portfolioRepository) {
        this.portfolioRepository = portfolioRepository;
    }

    public Portfolio createPortfolio(Portfolio portfolio) {
        return portfolioRepository.save(portfolio);
    }

    public List<Portfolio> getAllPortfolios() {
        return portfolioRepository.findAll();
    }

    public Portfolio getPortfolioById(Long id) {
        return portfolioRepository.findById(id).orElse(null);
    }

    public Portfolio updatePortfolio(Long id, Portfolio portfolio) {
        if (portfolioRepository.existsById(id)) {
            portfolio.setId(id);
            return portfolioRepository.save(portfolio);
        }
        return null; // Le portfolio avec cet ID n'existe pas
    }

    public boolean deletePortfolio(Long id) {
        if (portfolioRepository.existsById(id)) {
            portfolioRepository.deleteById(id);
            return true;
        }
        return false; // Le portfolio avec cet ID n'existe pas
    }
}

