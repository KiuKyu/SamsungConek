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
public class RoleController extends AbstractController {
    @Autowired
    private IRoleService roleService;
//    Find all role
    @GetMapping
    public ResponseEntity<?> findAllRoles() {
        return getResponseEntity(roleService.findAll());
    }
//    Create role
    @PostMapping
    public ResponseEntity<?> createRole(@RequestBody Role role) {
        return getResponseEntity(roleService.save(role));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne (@PathVariable Long id) {
        return getResponseEntity(roleService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update (@PathVariable Long id, Role role) {
        return getResponseEntity(roleService.update(id, role));
    }
}
