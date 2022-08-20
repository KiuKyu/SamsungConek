package com.samsungconek.controller;

import com.samsungconek.utils.CustomResponse;
import com.samsungconek.model.entity.Comment;
import com.samsungconek.service.comment.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/comments")
public class CommentController extends AbstractController {
    @Autowired
    private ICommentService commentService;

    @Value("${file-upload}")
    private String uploadPath;

    @GetMapping
    public ResponseEntity<?> findAll() {
        return getResponseEntity(commentService.findAll());
    }

    @PostMapping
    public ResponseEntity<?> postComment (@RequestBody Comment comment) {
        return getResponseEntity(commentService.save(comment));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne (@PathVariable Long id) {
        return getResponseEntity(commentService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable Long id) {
        return getResponseEntity(commentService.deleteById(id));
    }
}
