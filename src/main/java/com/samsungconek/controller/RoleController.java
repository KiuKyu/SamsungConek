package com.samsungconek.controller;

import com.samsungconek.utils.ResponseHandler;
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
        ResponseHandler responseHandler = new ResponseHandler("SUCCESS", 200, roles);
        return new ResponseEntity<>(responseHandler, HttpStatus.OK);
    }
//    Create role
    @PostMapping
    public ResponseEntity<?> createRole(@RequestBody Role role) {
        Role newRole = roleService.save(role);
        ResponseHandler responseHandler = new ResponseHandler("SUCCESS", 201, newRole);
        return new ResponseEntity<>(responseHandler, HttpStatus.CREATED);
    }
}
