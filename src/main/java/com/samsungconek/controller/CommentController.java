package com.samsungconek.controller;

import com.samsungconek.utils.ResponseHandler;
import com.samsungconek.model.entity.Comment;
import com.samsungconek.service.comment.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/comments")
public class CommentController {
    @Autowired
    private ICommentService commentService;

    @Value("${file-upload}")
    private String uploadPath;

    @GetMapping
    public ResponseEntity<?> findAll() {
        Iterable<Comment> comments = commentService.findAll();
        ResponseHandler responseHandler = new ResponseHandler("SUCCESS", 200, comments);
        return new ResponseEntity<>(responseHandler, HttpStatus.OK);
    }
}
