package com.example.mandelnyamsite.controllers;

import com.example.mandelnyamsite.models.Benefit;
import com.example.mandelnyamsite.services.BenefitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BenefitController {
    private final BenefitService benefitService;

    @Autowired
    public BenefitController(BenefitService benefitService) {
        this.benefitService = benefitService;
    }



    @PreAuthorize("hasAnyAuthority('admin','employee')")
    @GetMapping("/benefits")
    public String findAll(Model model) {
        List<Benefit> benefits = benefitService.findAll();
        model.addAttribute("benefits", benefits);
        return "benefit-list";
    }
    @PreAuthorize("hasAnyAuthority('admin','employee')")
    @GetMapping("/benefits/create")
    public String createBenefitForm(Benefit benefit) {
        return "benefit-create";
    }

    @PostMapping("/benefits/create")
    @PreAuthorize("hasAnyAuthority('admin','employee')")
    public String createBenefit(Benefit benefit) {

        benefitService.saveBenefit(benefit);
        return "redirect:/benefits";
    }

    @GetMapping("/benefits/update/{id}")
    @PreAuthorize("hasAnyAuthority('admin','employee')")
    public String updateBenefitForm(@PathVariable Long id, Model model) {
        Benefit benefit = benefitService.findById(id);
        model.addAttribute("benefit", benefit);
        return "benefit-update";
    }

    @PostMapping("/benefits/update")
    @PreAuthorize("hasAnyAuthority('admin','employee')")
    public String updateBenefit(Benefit benefit) {
        benefitService.saveBenefit(benefit);
        return "redirect:/benefits";
    }

    @GetMapping("/benefits/delete/{id}")
    @PreAuthorize("hasAnyAuthority('admin','employee')")
    public String deleteBenefit(@PathVariable Long id) {
        benefitService.deleteById(id);
        return "redirect:/benefits";
    }
}
