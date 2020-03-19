package com.notyfyd.service;

import com.notyfyd.entity.Role;
import com.notyfyd.entity.User;
import com.notyfyd.repository.RoleRepository;
import com.notyfyd.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleService {

    private RoleRepository roleRepository;
    private UserRepository userRepository;

    public RoleService(RoleRepository roleRepository, UserRepository userRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    /** Create a new role  */
    @Transactional
    public ResponseEntity<Object> addRole(Role role)  {

        Role newRole = new Role();
        newRole.setName(role.getName());
        newRole.setDescription(role.getDescription());
        List<Role> roleList = new ArrayList<>();
        roleList.add(newRole);
        for(int i=0; i< role.getUsers().size(); i++){
            if(!userRepository.findByEmail(role.getUsers().get(i).getEmail()).isPresent()) {
                User newUser = role.getUsers().get(i);
                newUser.setRoles(roleList);
                User savedUser = userRepository.save(newUser);
                if(! userRepository.findById(savedUser.getId()).isPresent())
                    return ResponseEntity.unprocessableEntity().body("Role Creation Failed");
            }
             else  return   ResponseEntity.unprocessableEntity().body("User with email Id is already Present");
        }
        return ResponseEntity.ok("Successfully created Role");
    }


    /** Delete a specified role given the id */
    public ResponseEntity<Object> deleteRole(Long id) {
        if(roleRepository.findById(id).isPresent()){
            if(roleRepository.getOne(id).getUsers().size() == 0) {
                roleRepository.deleteById(id);
                if (roleRepository.findById(id).isPresent()) {
                    return ResponseEntity.unprocessableEntity().body("Failed to delete the specified record");
                } else return ResponseEntity.ok().body("Successfully deleted specified record");
            } else return ResponseEntity.unprocessableEntity().body("Failed to delete,  Please delete the users associated with this role");
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
            if(roleRepository.findById(savedRole.getId()).isPresent())
                return ResponseEntity.accepted().body("Role saved successfully");
            else return ResponseEntity.badRequest().body("Failed to update Role");

        } else return ResponseEntity.unprocessableEntity().body("Specified Role not found");
    }
}









