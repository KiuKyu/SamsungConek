package com.samsungconek.controller;

import com.samsungconek.utils.CustomResponse;
import com.samsungconek.service.role.IRoleService;
import com.samsungconek.model.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/roles")
public class RoleController {
    @Autowired
    private IRoleService roleService;
//    Find all role
    @GetMapping
    public ResponseEntity<?> findAllRoles() {
        Iterable<Role> roles = roleService.findAll();
        CustomResponse customResponse = new CustomResponse("SUCCESS", 200, roles);
        return new ResponseEntity<>(customResponse, HttpStatus.OK);
    }
//    Create role
    @PostMapping
    public ResponseEntity<?> createRole(@RequestBody Role role) {
        Role newRole = roleService.save(role);
        CustomResponse customResponse = new CustomResponse("SUCCESS", 201, newRole);
        return new ResponseEntity<>(customResponse, HttpStatus.CREATED);
    }
}
