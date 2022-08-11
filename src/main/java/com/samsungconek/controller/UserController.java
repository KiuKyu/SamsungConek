package com.samsungconek.controller;

import com.samsungconek.utils.ResponseHandler;
import com.samsungconek.model.entity.User;
import com.samsungconek.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/users")
public class UserController {
    public final int ITEM_PER_PAGE = 10;

    @Autowired
    private IUserService userService;

    // Find all users + paging
    @GetMapping("/page/{pageNumber}")
    public ResponseEntity<?> findAll(@RequestParam(name = "q") Optional<String> q, @PathVariable int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, ITEM_PER_PAGE);
        Page<User> users = userService.findAll(pageable);
        ResponseHandler responseHandler = new ResponseHandler("SUCCESS", 200, users);
        return new ResponseEntity<>(responseHandler, HttpStatus.OK);
    }

    // Find user with ID
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<User> userOptional = userService.findById(id);
        if (!userOptional.isPresent()) {
            ResponseHandler responseHandler = new ResponseHandler("FAILURE", 404);
            return new ResponseEntity<>(responseHandler, HttpStatus.NOT_FOUND);
        }
        User user = userOptional.get();
        ResponseHandler responseHandler = new ResponseHandler("SUCCESS", 200, user);
        return new ResponseEntity<>(responseHandler, HttpStatus.OK);
    }
    // Create user = Register = làm phần này sau khi làm Security
}