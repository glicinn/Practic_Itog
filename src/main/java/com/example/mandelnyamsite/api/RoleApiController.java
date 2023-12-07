package com.example.mandelnyamsite.api;

import com.example.mandelnyamsite.models.Role;
import com.example.mandelnyamsite.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleApiController {

    private final RoleService roleService;

    @Autowired
    public RoleApiController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    public List<Role> getAllRoles() {
        return roleService.findAll();
    }

    @PostMapping
    public Role createRole(@RequestBody Role role) {
        return roleService.saveRole(role);
    }

    @GetMapping("/{id}")
    public Role getRoleById(@PathVariable Long id) {
        return roleService.findById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Role> updateRole(@PathVariable Long id, @RequestBody Role updatedRole) {
        // Проверка существования роли с заданным id
        Role existingRole = roleService.findById(id);
        if (existingRole == null) {
            return ResponseEntity.notFound().build();
        }

        // Обновление полей роли
        existingRole.setRoleName(updatedRole.getRoleName());
        // Сохранение обновленной роли
        Role updatedRoleData = roleService.saveRole(existingRole);

        return ResponseEntity.ok(updatedRoleData);
    }

    @DeleteMapping("/{id}")
    public void deleteRole(@PathVariable Long id) {
        roleService.deleteById(id);
    }
}