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
public class SpecController {
    @Autowired
    private ISpecService specService;

//    find all specs
    @GetMapping
    public ResponseEntity<?> findAll() {
        Iterable<Spec> specs = specService.findAll();
        CustomResponse customResponse = new CustomResponse("SUCCESS", 200, specs);
        return new ResponseEntity<>(customResponse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createSpec(@RequestBody Spec spec) {
        Spec newSpec = specService.save(spec);
        CustomResponse customResponse = new CustomResponse("SUCCESS", 201, newSpec);
        return new ResponseEntity<>(customResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateSpec(@PathVariable Long id, @RequestBody Spec newSpec) {
        Optional<Spec> specOptional = specService.findById(id);
        if (!specOptional.isPresent()) {
            CustomResponse customResponse = new CustomResponse("FAILURE", 404);
            return new ResponseEntity<>(customResponse, HttpStatus.NOT_FOUND);
        } else {
            Spec oldSpec = specOptional.get();
            oldSpec.setId(id);
            oldSpec.setName(newSpec.getName());
            specService.save(oldSpec);
            CustomResponse customResponse = new CustomResponse("SUCCESS", 200, oldSpec);
            return new ResponseEntity<>(customResponse, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSpec(@PathVariable Long id) {
        Optional<Spec> specOptional = specService.findById(id);
        if (!specOptional.isPresent()) {
            CustomResponse customResponse = new CustomResponse("FAILURE", 404);
            return new ResponseEntity<>(customResponse, HttpStatus.NOT_FOUND);
        } else {
            Spec deletedSpec = specOptional.get();
            specService.deleteById(id);
            CustomResponse customResponse = new CustomResponse("SUCCESS", 200, deletedSpec);
            return new ResponseEntity<>(customResponse, HttpStatus.OK);
        }
    }
}
