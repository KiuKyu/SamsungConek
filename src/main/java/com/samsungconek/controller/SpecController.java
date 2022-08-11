package com.samsungconek.controller;

import com.samsungconek.utils.ResponseHandler;
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
        ResponseHandler responseHandler = new ResponseHandler("SUCCESS", 200, specs);
        return new ResponseEntity<>(responseHandler, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createSpec(@RequestBody Spec spec) {
        Spec newSpec = specService.save(spec);
        ResponseHandler responseHandler = new ResponseHandler("SUCCESS", 201, newSpec);
        return new ResponseEntity<>(responseHandler, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateSpec(@PathVariable Long id, @RequestBody Spec newSpec) {
        Optional<Spec> specOptional = specService.findById(id);
        if (!specOptional.isPresent()) {
            ResponseHandler responseHandler = new ResponseHandler("FAILURE", 404);
            return new ResponseEntity<>(responseHandler, HttpStatus.NOT_FOUND);
        } else {
            Spec oldSpec = specOptional.get();
            oldSpec.setId(id);
            oldSpec.setName(newSpec.getName());
            specService.save(oldSpec);
            ResponseHandler responseHandler = new ResponseHandler("SUCCESS", 200, oldSpec);
            return new ResponseEntity<>(responseHandler, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSpec(@PathVariable Long id) {
        Optional<Spec> specOptional = specService.findById(id);
        if (!specOptional.isPresent()) {
            ResponseHandler responseHandler = new ResponseHandler("FAILURE", 404);
            return new ResponseEntity<>(responseHandler, HttpStatus.NOT_FOUND);
        } else {
            Spec deletedSpec = specOptional.get();
            specService.deleteById(id);
            ResponseHandler responseHandler = new ResponseHandler("SUCCESS", 200, deletedSpec);
            return new ResponseEntity<>(responseHandler, HttpStatus.OK);
        }
    }
}
