package com.samsungconek.controller;

import com.samsungconek.model.entity.Brand;
import com.samsungconek.model.dto.BrandDto;
import com.samsungconek.utils.ResponseHandler;
import com.samsungconek.model.entity.Logger;
import com.samsungconek.service.brand.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/brands")
public class BrandController {
    @Autowired
    private IBrandService brandService;

    @Value("${file-upload}")
    private String uploadPath;

    //    Find all brands
    @GetMapping
    public ResponseEntity<?> findAll() {
        Iterable<Brand> brands = brandService.findAll();
        ResponseHandler responseHandler = new ResponseHandler("SUCCESS", 200, brands);
        return new ResponseEntity<>(responseHandler, HttpStatus.OK);
    }

    //    Find brand by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Brand> brandOptional = brandService.findById(id);
        if (!brandOptional.isPresent()) {
            ResponseHandler responseHandler = new ResponseHandler("FAILURE", 404);
            return new ResponseEntity<>(responseHandler, HttpStatus.NOT_FOUND);
        }
        Brand brand = brandOptional.get();
        ResponseHandler responseHandler = new ResponseHandler("SUCCESS", 200, brand);
        return new ResponseEntity<>(responseHandler, HttpStatus.OK);
    }

    //    Create new brand
    @PostMapping
    public ResponseEntity<?> createBrand(@ModelAttribute BrandDto brandDto) {
        MultipartFile img = brandDto.getImage();
        if (img != null && img.getSize() != 0) {
            Logger logger = new Logger();
            String fileName = img.getOriginalFilename();
            long currentTime = System.currentTimeMillis();
            logger.setLogTime(currentTime);
            fileName = currentTime + "_" + fileName;
            try {
                FileCopyUtils.copy(img.getBytes(), new File(uploadPath + fileName));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            // Get User để truyền vào trong String.format
//            String logDetails = String.format("Người dùng: ABC đã tạo mới hãng");
//            Thay arg của setDetails = logDetails khi làm được
            logger.setDetails("Người dùng ... đã tạo mới hãng");
            Brand newBrand = new Brand();
            newBrand.setName(brandDto.getName());
            newBrand.setDescription(brandDto.getDescription());
            newBrand.setImage(fileName);
            brandService.save(newBrand);
            ResponseHandler responseHandler = new ResponseHandler("SUCCESS", 201, newBrand);

            return new ResponseEntity<>(responseHandler, HttpStatus.CREATED);
        }
        ResponseHandler responseHandler = new ResponseHandler("FAILURE", 400);
        return new ResponseEntity<>(responseHandler, HttpStatus.BAD_REQUEST);
    }

    //    Update existing brand
    @PutMapping("/{id}")
    public ResponseEntity<?> updateById(@PathVariable Long id, @ModelAttribute BrandDto brandDto) {
        Optional<Brand> brandOptional = brandService.findById(id);
        if (!brandOptional.isPresent()) {
            ResponseHandler responseHandler = new ResponseHandler("FAILURE", 404);
            return new ResponseEntity<>(responseHandler, HttpStatus.BAD_REQUEST);
        } else {
            Brand oldBrand = brandOptional.get();
            oldBrand.setId(id);
            oldBrand.setName(brandDto.getName());
            oldBrand.setDescription(brandDto.getDescription());

            MultipartFile img = brandDto.getImage();
            if (img != null && img.getSize() != 0) {
                String fileName = img.getOriginalFilename();
                long currentTime = System.currentTimeMillis();
                fileName = currentTime + "_" + fileName;
                try {
                    FileCopyUtils.copy(img.getBytes(), new File(uploadPath + fileName));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                oldBrand.setImage(fileName);
            }
            brandService.save(oldBrand);
            ResponseHandler responseHandler = new ResponseHandler("SUCCESS", 200, oldBrand);
            return new ResponseEntity<>(responseHandler, HttpStatus.OK);
        }
    }

    //    Delete brand
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        Optional<Brand> brandOptional = brandService.findById(id);
        if (!brandOptional.isPresent()) {
            ResponseHandler responseHandler = new ResponseHandler("SUCCESS", 404);
            return new ResponseEntity<>(responseHandler, HttpStatus.NOT_FOUND);
        } else {
            brandService.deleteById(id);
            Brand deletedBrand = brandOptional.get();
            ResponseHandler responseHandler = new ResponseHandler("SUCCESS", 200, deletedBrand);
            return new ResponseEntity<>(responseHandler, HttpStatus.OK);
        }
    }
}
