package com.example.mandelnyamsite.controllers;

import com.example.mandelnyamsite.models.Role;
import com.example.mandelnyamsite.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class RoleController {
    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }



    @PreAuthorize("hasAnyAuthority('admin','employee')")
    @GetMapping("/roles")
    public String findAll(Model model) {
        List<Role> roles = roleService.findAll();
        model.addAttribute("roles", roles);
        return "role-list";
    }
    @PreAuthorize("hasAnyAuthority('admin','employee')")
    @GetMapping("/roles/create")
    public String createRoleForm(Role role) {
        return "role-create";
    }

    @PostMapping("/roles/create")
    @PreAuthorize("hasAnyAuthority('admin','employee')")
    public String createRole(Role role) {
        roleService.saveRole(role);
        return "redirect:/roles";
    }

    @GetMapping("/roles/update/{id}")
    @PreAuthorize("hasAnyAuthority('admin','employee')")
    public String updateRoleForm(@PathVariable Long id, Model model) {
        Role role = roleService.findById(id);
        model.addAttribute("role", role);
        return "role-update";
    }

    @PostMapping("/roles/update")
    @PreAuthorize("hasAnyAuthority('admin','employee')")
    public String updateRole(Role role) {
        roleService.saveRole(role);
        return "redirect:/roles";
    }

    @GetMapping("/roles/delete/{id}")
    @PreAuthorize("hasAnyAuthority('admin','employee')")
    public String deleteRole(@PathVariable Long id) {
        roleService.deleteById(id);
        return "redirect:/roles";
    }
}
