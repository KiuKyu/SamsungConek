package com.samsungconek.controller;

import com.samsungconek.model.dto.ProductDto;
import com.samsungconek.service.product.IProductService;
import com.samsungconek.utils.ResponseHandler;
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
public class ProductController {
    @Autowired
    private IProductService productService;

    @Value("${file-upload}")
    private String uploadPath;

    public final int ITEM_PER_PAGE = 10;

//    find all
    @GetMapping
    public ResponseEntity<?> findAll() {
        Iterable<Product> products = productService.findAll();
        ResponseHandler responseHandler = new ResponseHandler("SUCCESS", 200, products);
        return new ResponseEntity<>(responseHandler, HttpStatus.OK);
    }

    // find all + paging
    @GetMapping("/page/{pageNumber}")
    public ResponseEntity<?> findAll(@PathVariable int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, ITEM_PER_PAGE);
        Page<Product> products = productService.findAll(pageable);
        ResponseHandler responseHandler = new ResponseHandler("SUCCESS", 200, products);
        return new ResponseEntity<>(responseHandler, HttpStatus.OK);
    }

    // create product
    @PostMapping
    public ResponseEntity<Product> createProduct(@ModelAttribute ProductDto productDto) {
        // Làm phần list image sau
//        List<ProductImageDto> productImages = productDto.getProductImages();
//        if (!productImages.isEmpty()) {
//
//        }
        Product product = new Product();
        product.setName(productDto.getName());
        product.setCategories(productDto.getCategories());
        product.setPrice(productDto.getPrice());
        product.setStock(productDto.getStock());
        product.setDiscount(productDto.getDiscount());
        product.setColor(productDto.getColor());
        product.setPriority(productDto.getPriority());
        product.setStatus(productDto.isStatus());

        long currentTime = System.currentTimeMillis();
//        product.setCreateDate(currentTime);

        return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
    }

    // find by id
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            ResponseHandler responseHandler = new ResponseHandler("FAILURE", 404);
            return new ResponseEntity<>(responseHandler, HttpStatus.NOT_FOUND);
        } else {
            Product product = productOptional.get();
            ResponseHandler responseHandler = new ResponseHandler("SUCCESS", 200, product);
            return new ResponseEntity<>(responseHandler, HttpStatus.OK);
        }
    }

    // update product
    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Long id, @ModelAttribute ProductDto productDto) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            ResponseHandler responseHandler = new ResponseHandler("FAILURE", 404);
            return new ResponseEntity<>(responseHandler, HttpStatus.NOT_FOUND);
        } else {
            Product oldProduct = new Product();
            oldProduct.setId(id);
            oldProduct.setName(productDto.getName());
            oldProduct.setCategories(productDto.getCategories());
            oldProduct.setDiscount(productDto.getDiscount());
            oldProduct.setPrice(productDto.getPrice());
            oldProduct.setPriority(productDto.getPriority());
            oldProduct.setStatus(productDto.isStatus());
            oldProduct.setColor(productDto.getColor());
            oldProduct.setStock(productDto.getStock());

            long currentTime = System.currentTimeMillis();
//            oldProduct.setModifyDate(currentTime);

            return new ResponseEntity<>(productService.save(oldProduct), HttpStatus.OK);
        }
    }
}
