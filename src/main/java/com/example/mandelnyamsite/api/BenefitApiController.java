package com.example.mandelnyamsite.api;

import com.example.mandelnyamsite.models.Benefit;
import com.example.mandelnyamsite.services.BenefitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/benefits")
public class BenefitApiController {

    private final BenefitService benefitService;

    @Autowired
    public BenefitApiController(BenefitService benefitService) {
        this.benefitService = benefitService;
    }

    @GetMapping
    public List<Benefit> getAllBenefits() {
        return benefitService.findAll();
    }

    @PostMapping
    public Benefit createBenefit(@RequestBody Benefit benefit) {
        return benefitService.saveBenefit(benefit);
    }

    @GetMapping("/{id}")
    public Benefit getBenefitById(@PathVariable Long id) {
        return benefitService.findById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Benefit> updateBenefit(@PathVariable Long id, @RequestBody Benefit updatedBenefit) {
        // Проверка существования льготы с заданным id
        Benefit existingBenefit = benefitService.findById(id);
        if (existingBenefit == null) {
            return ResponseEntity.notFound().build();
        }

        // Обновление полей льготы
        existingBenefit.setBenefitName(updatedBenefit.getBenefitName());
        existingBenefit.setBenefitDiscount(updatedBenefit.getBenefitDiscount());
        // Сохранение обновленной льготы
        Benefit updatedBenefitData = benefitService.saveBenefit(existingBenefit);
        return ResponseEntity.ok(updatedBenefitData);
    }

    @DeleteMapping("/{id}")
    public void deleteBenefit(@PathVariable Long id) {
        benefitService.deleteById(id);
    }
}