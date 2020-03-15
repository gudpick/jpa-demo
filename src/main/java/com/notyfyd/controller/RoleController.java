package com.notyfyd.controller;

import com.notyfyd.entity.Role;
import com.notyfyd.service.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class RoleController {

    private RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping("/role/create")
    public ResponseEntity<Object> createRole(@RequestBody Role role) {
        return  roleService.addRole(role);
    }
    @DeleteMapping("/role/delete/{id}")
    public ResponseEntity<Object> deleteRole(@PathVariable Long id) {
        return roleService.deleteRole(id);
    }
}