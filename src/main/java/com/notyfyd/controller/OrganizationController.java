package com.notyfyd.controller;

import com.notyfyd.entity.Organization;
import com.notyfyd.repository.OrganizationRepository;
import com.notyfyd.service.OrganizationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrganizationController {
    private OrganizationService organizationService;
    private OrganizationRepository organizationRepository;

    public OrganizationController(OrganizationService organizationService, OrganizationRepository organizationRepository) {
        this.organizationService = organizationService;
        this.organizationRepository = organizationRepository;
    }

    @PostMapping("/organization/create")
    public ResponseEntity<Object> createOrganization(@RequestBody Organization organization) {
        return organizationService.createOrganization(organization);
    }
    @DeleteMapping("/organization/delete/{id}")
    public ResponseEntity<Object> deleteOrganization(@PathVariable Long id) {
        if(organizationRepository.findById(id).isPresent()) {
            organizationRepository.deleteById(id);
            if (organizationRepository.findById(id).isPresent())
                return ResponseEntity.unprocessableEntity().body("Failed to delete the specified organization");
            else return ResponseEntity.ok("Successfully deleted the specified organization");
        } else return ResponseEntity.unprocessableEntity().body("Specified organization not present");
    }
    @GetMapping("/organization/get/{id}")
    public Organization getOrganization(@PathVariable Long id) {
        if(organizationRepository.findById(id).isPresent())
            return organizationRepository.findById(id).get();
        else return null;
    }
    @GetMapping("/organization/get")
    public List<Organization> getOrganizations() {
        return organizationRepository.findAll();
    }

    @PutMapping("/organization/update/{id}")
    public ResponseEntity<Object> updateOrganization(@PathVariable Long id, @RequestBody Organization org) {
        return organizationService.updateOrganization(id, org);
    }


}
