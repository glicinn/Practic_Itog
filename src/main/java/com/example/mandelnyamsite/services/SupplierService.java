package com.example.mandelnyamsite.services;

import com.example.mandelnyamsite.models.Supplier;
import com.example.mandelnyamsite.models.User;
import com.example.mandelnyamsite.repos.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {

    private final SupplierRepository supplierRepository;
    private final UserService userService;

    @Autowired
    public SupplierService(SupplierRepository supplierRepository, UserService userService) {
        this.supplierRepository = supplierRepository;
        this.userService = userService;
    }

    public List<Supplier> findAll() {
        return supplierRepository.findAll();
    }

    public Supplier findById(Long id) {
        return supplierRepository.findById(id).orElse(null);
    }

    public Supplier saveSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    public void deleteById(Long id) {
        supplierRepository.deleteById(id);
    }

    public List<User> findAllUsers() {
        return userService.findAll();
    }

}
