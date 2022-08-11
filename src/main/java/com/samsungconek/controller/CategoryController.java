package com.samsungconek.controller;

import com.samsungconek.model.entity.Category;
import com.samsungconek.utils.ResponseHandler;
import com.samsungconek.service.category.ICategoryService;
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
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    public final int ITEM_PER_PAGE = 10;

    //    find all cate
    @GetMapping
    public ResponseEntity<?> findAll() {
        Iterable<Category> categories = categoryService.findAll();
        ResponseHandler responseHandler = new ResponseHandler("SUCCESS", 200, categories);
        return new ResponseEntity<>(responseHandler, HttpStatus.OK);
    }

    //    find all cate (paging)
    @GetMapping("/page/{pageNumber}")
    public ResponseEntity<?> findAllPage(@RequestParam(name = "q") Optional<String> q, @PathVariable int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, ITEM_PER_PAGE);
        Page<Category> categories = categoryService.findAll(pageable);
        // thêm phần search theo từ khóa ở đây
        ResponseHandler responseHandler = new ResponseHandler("SUCCESS", 200, categories);
        return new ResponseEntity<>(responseHandler, HttpStatus.OK);
    }

    //    find cate by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Category> categoryOptional = categoryService.findById(id);
        if (!categoryOptional.isPresent()) {
            ResponseHandler responseHandler = new ResponseHandler("FAILURE", 404);
            return new ResponseEntity<>(responseHandler, HttpStatus.NOT_FOUND);
        }
        Category category = categoryOptional.get();
        ResponseHandler responseHandler = new ResponseHandler("SUCCESS", 200, category);
        return new ResponseEntity<>(responseHandler, HttpStatus.OK);
    }

    //    add new cate
    @PostMapping
    public ResponseEntity<?> createCategory(@RequestBody Category category) {
        Category newCategory = categoryService.save(category);
        ResponseHandler responseHandler = new ResponseHandler("SUCCESS", 201, newCategory);
        return new ResponseEntity<>(responseHandler, HttpStatus.CREATED);
    }

    //    edit category
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable Long id, @RequestBody Category newCategory) {
        Optional<Category> categoryOptional = categoryService.findById(id);
        if (!categoryOptional.isPresent()) {
            ResponseHandler responseHandler = new ResponseHandler("FAILURE", 404);
            return new ResponseEntity<>(responseHandler, HttpStatus.NOT_FOUND);
        } else {
            Category oldCategory = new Category();
            oldCategory.setId(id);
            oldCategory.setName(newCategory.getName());
            oldCategory.setBrands(newCategory.getBrands());
            oldCategory.setStatus(newCategory.isStatus());
            // oldCategory.setLevel(newCategory.getLevel());
            oldCategory.setParentCategory(newCategory.getParentCategory());
            oldCategory.setSpecs(newCategory.getSpecs());
            categoryService.save(oldCategory);
            ResponseHandler responseHandler = new ResponseHandler("SUCCESS", 200, oldCategory);
            return new ResponseEntity<>(responseHandler, HttpStatus.OK);
        }
    }

    //    delete cate
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id) {
        Optional<Category> categoryOptional = categoryService.findById(id);
        if (!categoryOptional.isPresent()) {
            ResponseHandler responseHandler = new ResponseHandler("FAILURE", 404);
            return new ResponseEntity<>(responseHandler, HttpStatus.NOT_FOUND);
        } else {
            categoryService.deleteById(id);
            Category deletedCategory = categoryOptional.get();
            ResponseHandler responseHandler = new ResponseHandler("SUCCESS", 200, deletedCategory);
            return new ResponseEntity<>(responseHandler, HttpStatus.OK);
        }
    }

    @GetMapping("/header")
    public ResponseEntity<?> showHeaderCategory() {
        Iterable<Category> categories = categoryService.findAllByParentCategoryIsNull();
        ResponseHandler responseHandler = new ResponseHandler("OK", 200, categories);
        return new ResponseEntity<>(responseHandler, HttpStatus.OK);
    }
}
