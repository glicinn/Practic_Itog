package com.example.mandelnyamsite.services;

import com.example.mandelnyamsite.models.Benefit;
import com.example.mandelnyamsite.models.Role;
import com.example.mandelnyamsite.repos.BenefitRepository;
import com.example.mandelnyamsite.repos.CategoryRepository;
import com.example.mandelnyamsite.repos.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    public Role findById(Long id) {
        return roleRepository.findById(id).orElse(null);
    }

    public Role saveRole(Role role) { return roleRepository.save(role); }

    public void deleteById(Long id) {
        roleRepository.deleteById(id);
    }

}
