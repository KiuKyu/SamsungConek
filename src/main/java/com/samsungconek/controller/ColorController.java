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
public class ColorController {
    @Autowired
    private IColorService colorService;

//    get all color
    @GetMapping
    public ResponseEntity<?> findAll() {
        Iterable<Color> colors = colorService.findAll();
        CustomResponse customResponse = new CustomResponse("SUCCESS", 200, colors);
        return new ResponseEntity<>(customResponse, HttpStatus.OK);
    }

//    post new color
    @PostMapping
    public ResponseEntity<?> createColor(@RequestBody Color color) {
        Color newColor = colorService.save(color);
        CustomResponse customResponse = new CustomResponse("SUCCESS", 201, newColor);
        return new ResponseEntity<>(customResponse, HttpStatus.CREATED);
    }

//    edit color
    @PutMapping("/{id}")
    public ResponseEntity<?> editColor(@PathVariable Long id, @RequestBody Color color) {
        Optional<Color> colorOptional = colorService.findById(id);
        if (!colorOptional.isPresent()) {
            CustomResponse customResponse = new CustomResponse("FAILURE", 404);
            return new ResponseEntity<>(customResponse, HttpStatus.NOT_FOUND);
        } else {
            Color oldColor = colorOptional.get();
            oldColor.setId(id);
            oldColor.setName(color.getName());
            colorService.save(oldColor);
            CustomResponse customResponse = new CustomResponse("SUCCESS", 200, oldColor);
            return new ResponseEntity<>(customResponse, HttpStatus.OK);
        }
    }

//    delete color
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleleColor(@PathVariable Long id) {
        Optional<Color> colorOptional = colorService.findById(id);
        if (!colorOptional.isPresent()) {
            CustomResponse customResponse = new CustomResponse("FAILURE", 404);
            return new ResponseEntity<>(customResponse, HttpStatus.NOT_FOUND);
        } else {
            colorService.deleteById(id);
            Color deletedColor = colorOptional.get();
            CustomResponse customResponse = new CustomResponse("SUCCESS", 200, deletedColor);
            return new ResponseEntity<>(customResponse, HttpStatus.OK);
        }
    }
}
