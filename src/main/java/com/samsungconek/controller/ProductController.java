package com.samsungconek.controller;

import com.samsungconek.model.dto.ProductDto;
import com.samsungconek.service.product.IProductService;
import com.samsungconek.utils.CustomResponse;
import com.samsungconek.model.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/products")
public class ProductController extends AbstractController {
    @Autowired
    private IProductService productService;

    @Value("${file-upload}")
    private String uploadPath;

    public final int ITEM_PER_PAGE = 10;

//    find all
    @GetMapping
    public ResponseEntity<?> findAll() {
        return getResponseEntity(productService.findAll());
    }

    // find all + paging
    @GetMapping("/page/{pageNumber}")
    public ResponseEntity<?> findAll(@PathVariable int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, ITEM_PER_PAGE);
        Page<Product> products = productService.findAll(pageable);
        CustomResponse customResponse = new CustomResponse("SUCCESS", 200, products);
        return new ResponseEntity<>(customResponse, HttpStatus.OK);
    }

    // create product
    @PostMapping
    public ResponseEntity<?> createProduct(@ModelAttribute ProductDto productDto) {
        // Làm phần list image sau
        return getResponseEntity(productService.save(productDto));
    }

    // find by id
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return getResponseEntity(productService.findById(id));
    }

    // update product
    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Long id, @ModelAttribute ProductDto productDto) {
        return getResponseEntity(productService.update(id, productDto));
    }
}
