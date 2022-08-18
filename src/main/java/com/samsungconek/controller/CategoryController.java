package com.samsungconek.controller;

import com.samsungconek.model.entity.Category;
import com.samsungconek.utils.CustomResponse;
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

        CustomResponse customResponse = new CustomResponse("SUCCESS", 200, categories);
        return new ResponseEntity<>(customResponse, HttpStatus.OK);
    }

    //    find all cate (paging)
    @GetMapping("/page/{pageNumber}")
    public ResponseEntity<?> findAllPage(@RequestParam(name = "q") Optional<String> q, @PathVariable int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, ITEM_PER_PAGE);
        Page<Category> categories = categoryService.findAll(pageable);
        // thêm phần search theo từ khóa ở đây
        CustomResponse customResponse = new CustomResponse("SUCCESS", 200, categories);
        return new ResponseEntity<>(customResponse, HttpStatus.OK);
    }

    //    find cate by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Category> categoryOptional = categoryService.findById(id);
        if (!categoryOptional.isPresent()) {
            CustomResponse customResponse = new CustomResponse("FAILURE", 404);
            return new ResponseEntity<>(customResponse, HttpStatus.NOT_FOUND);
        }
        Category category = categoryOptional.get();
        CustomResponse customResponse = new CustomResponse("SUCCESS", 200, category);
        return new ResponseEntity<>(customResponse, HttpStatus.OK);
    }

    //    add new cate
    @PostMapping
    public ResponseEntity<?> createCategory(@RequestBody Category category) {
        Category newCategory = categoryService.save(category);
        CustomResponse customResponse = new CustomResponse("SUCCESS", 201, newCategory);
        return new ResponseEntity<>(customResponse, HttpStatus.CREATED);
    }

    //    edit category
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable Long id, @RequestBody Category newCategory) {
        Optional<Category> categoryOptional = categoryService.findById(id);
        if (!categoryOptional.isPresent()) {
            CustomResponse customResponse = new CustomResponse("FAILURE", 404);
            return new ResponseEntity<>(customResponse, HttpStatus.NOT_FOUND);
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
            CustomResponse customResponse = new CustomResponse("SUCCESS", 200, oldCategory);
            return new ResponseEntity<>(customResponse, HttpStatus.OK);
        }
    }

    //    delete cate
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id) {
        Optional<Category> categoryOptional = categoryService.findById(id);
        if (!categoryOptional.isPresent()) {
            CustomResponse customResponse = new CustomResponse("FAILURE", 404);
            return new ResponseEntity<>(customResponse, HttpStatus.NOT_FOUND);
        } else {
            categoryService.deleteById(id);
            Category deletedCategory = categoryOptional.get();
            CustomResponse customResponse = new CustomResponse("SUCCESS", 200, deletedCategory);
            return new ResponseEntity<>(customResponse, HttpStatus.OK);
        }
    }

    @GetMapping("/header")
    public ResponseEntity<?> showHeaderCategory() {
        Iterable<Category> categories = categoryService.findAllByParentCategoryIsNull();
        CustomResponse customResponse = new CustomResponse("OK", 200, categories);
        return new ResponseEntity<>(customResponse, HttpStatus.OK);
    }
}
