package com.samsungconek.controller;

import com.samsungconek.utils.CustomResponse;
import com.samsungconek.model.entity.Spec;
import com.samsungconek.service.spec.ISpecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/specs")
public class SpecController extends AbstractController {
    @Autowired
    private ISpecService specService;

//    find all specs
    @GetMapping
    public ResponseEntity<?> findAll() {
        return getResponseEntity(specService.findAll());
    }

    @PostMapping
    public ResponseEntity<?> createSpec(@RequestBody Spec spec) {
        return getResponseEntity(specService.save(spec));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateSpec(@PathVariable Long id, @RequestBody Spec newSpec) {
        return getResponseEntity(specService.update(id, newSpec));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSpec(@PathVariable Long id) {
        return getResponseEntity(specService.deleteById(id));
    }
}
