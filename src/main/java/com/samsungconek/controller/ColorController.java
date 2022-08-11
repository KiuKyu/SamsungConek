package com.samsungconek.controller;

import com.samsungconek.model.entity.Color;
import com.samsungconek.utils.ResponseHandler;
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
        ResponseHandler responseHandler = new ResponseHandler("SUCCESS", 200, colors);
        return new ResponseEntity<>(responseHandler, HttpStatus.OK);
    }

//    post new color
    @PostMapping
    public ResponseEntity<?> createColor(@RequestBody Color color) {
        Color newColor = colorService.save(color);
        ResponseHandler responseHandler = new ResponseHandler("SUCCESS", 201, newColor);
        return new ResponseEntity<>(responseHandler, HttpStatus.CREATED);
    }

//    edit color
    @PutMapping("/{id}")
    public ResponseEntity<?> editColor(@PathVariable Long id, @RequestBody Color color) {
        Optional<Color> colorOptional = colorService.findById(id);
        if (!colorOptional.isPresent()) {
            ResponseHandler responseHandler = new ResponseHandler("FAILURE", 404);
            return new ResponseEntity<>(responseHandler, HttpStatus.NOT_FOUND);
        } else {
            Color oldColor = colorOptional.get();
            oldColor.setId(id);
            oldColor.setName(color.getName());
            colorService.save(oldColor);
            ResponseHandler responseHandler = new ResponseHandler("SUCCESS", 200, oldColor);
            return new ResponseEntity<>(responseHandler, HttpStatus.OK);
        }
    }

//    delete color
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleleColor(@PathVariable Long id) {
        Optional<Color> colorOptional = colorService.findById(id);
        if (!colorOptional.isPresent()) {
            ResponseHandler responseHandler = new ResponseHandler("FAILURE", 404);
            return new ResponseEntity<>(responseHandler, HttpStatus.NOT_FOUND);
        } else {
            colorService.deleteById(id);
            Color deletedColor = colorOptional.get();
            ResponseHandler responseHandler = new ResponseHandler("SUCCESS", 200, deletedColor);
            return new ResponseEntity<>(responseHandler, HttpStatus.OK);
        }
    }
}
