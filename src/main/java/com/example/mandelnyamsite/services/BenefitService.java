package com.example.mandelnyamsite.services;

import com.example.mandelnyamsite.models.Benefit;
import com.example.mandelnyamsite.repos.BenefitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BenefitService {

    private final BenefitRepository benefitRepository;

    @Autowired
    public BenefitService(BenefitRepository benefitRepository) {
        this.benefitRepository = benefitRepository;
    }

    public List<Benefit> findAll() {
        return benefitRepository.findAll();
    }

    public Benefit findById(Long id) {
        return benefitRepository.findById(id).orElse(null);
    }

    public Benefit saveBenefit(Benefit benefit) { return benefitRepository.save(benefit); }

    public void deleteById(Long id) {
        benefitRepository.deleteById(id);
    }

}
