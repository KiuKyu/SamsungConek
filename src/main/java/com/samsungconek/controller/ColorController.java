package com.samsungconek.controller;

import com.samsungconek.model.entity.Color;
import com.samsungconek.utils.CustomResponse;
import com.samsungconek.service.color.IColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/color")
public class ColorController extends AbstractController {
    @Autowired
    private IColorService colorService;

//    get all color
    @GetMapping
    public ResponseEntity<?> findAll() {
        return getResponseEntity(colorService.findAll());
    }

//    post new color
    @PostMapping
    public ResponseEntity<?> createColor(@RequestBody Color color) {
        return getResponseEntity(colorService.save(color));
    }

//    edit color
    @PutMapping("/{id}")
    public ResponseEntity<?> editColor(@PathVariable Long id, @RequestBody Color color) {
        return getResponseEntity(colorService.update(id, color));
    }

//    delete color
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleleColor(@PathVariable Long id) {
        return getResponseEntity(colorService.deleteById(id));
    }
}
