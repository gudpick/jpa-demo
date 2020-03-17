package com.notyfyd.service;

import com.notyfyd.entity.Role;
import com.notyfyd.repository.RoleRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    private RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    /** Create a new role  */
    public ResponseEntity<Object> addRole(Role role)  {

        Role newRole = new Role();
        newRole.setName(role.getName());
        newRole.setDescription(role.getDescription());
        Role savedRole = roleRepository.save(newRole);
        if(roleRepository.findById(savedRole.getId()).isPresent()) {
            return ResponseEntity.accepted().body("Successfully Created Role ");
        } else
            return ResponseEntity.unprocessableEntity().body("Failed to Create specified Role");
    }


    /** Delete a specified role given the id */
    public ResponseEntity<Object> deleteRole(Long id) {
        if(roleRepository.findById(id).isPresent()){
            roleRepository.deleteById(id);
            if(roleRepository.findById(id).isPresent()){
                return ResponseEntity.unprocessableEntity().body("Failed to delete the specified record");
            } else return ResponseEntity.ok().body("Successfully deleted specified record");
        } else
            return ResponseEntity.unprocessableEntity().body("No Records Found");
    }


    /** Update a Role */
    public ResponseEntity<Object> updateRole(Long id, Role role) {
        if(roleRepository.findById(id).isPresent()){
            Role newRole = roleRepository.findById(id).get();
            newRole.setName(role.getName());
            newRole.setDescription(role.getDescription());
            Role savedRole = roleRepository.save(newRole);
            if(roleRepository.findById(id).isPresent())
                return ResponseEntity.accepted().body("Role saved successfully");
            else return ResponseEntity.badRequest().body("Failed to update Role");

        } else return ResponseEntity.unprocessableEntity().body("Specified Role not found");
    }
}









