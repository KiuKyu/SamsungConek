package com.samsungconek.controller;

import com.samsungconek.utils.CustomResponse;
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
public class UserController extends AbstractController {
    public final int ITEM_PER_PAGE = 10;

    @Autowired
    private IUserService userService;

    // Find all users + paging
    @GetMapping("/page/{pageNumber}")
    public ResponseEntity<?> findAll(@RequestParam(name = "q") Optional<String> q, @PathVariable int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, ITEM_PER_PAGE);
        Page<User> users = userService.findAll(pageable);
        CustomResponse customResponse = new CustomResponse("SUCCESS", 200, users);
        return new ResponseEntity<>(customResponse, HttpStatus.OK);
    }

    // Find user with ID
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return getResponseEntity(userService.findById(id));
    }
    // Create user = Register = làm phần này sau khi làm Security

//    @PutMapping()
}