package com.samsungconek.service.brand;

import com.samsungconek.model.dto.BrandDto;
import com.samsungconek.model.entity.Brand;
import com.samsungconek.repository.IBrandRepository;
import com.samsungconek.service.base.A_Service;
import com.samsungconek.utils.CustomResponse;
import com.samsungconek.utils.exception.BusinessAssert;
import com.samsungconek.utils.exception.BusinessExceptionCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class BrandService extends A_Service implements IBrandService {
    @Autowired
    private IBrandRepository brandRepository;

    @Value("${file-upload}")
    private String uploadPath;

    @Override
    public List<Brand> findAll() {
        List<Brand> brandList = brandRepository.findAll();
        BusinessAssert.isTrue(brandList.size() > 0, BusinessExceptionCode.EMPTY_LIST, "Danh sách trống");
        return brandList;
    }

    @Override
    public Brand findById(Long id) {
        Optional<Brand> brandOptional = brandRepository.findById(id);
        BusinessAssert.isTrue(brandOptional.isPresent(), BusinessExceptionCode.NOT_EXIST, "Không tồn tại");
        return brandOptional.get();
    }

    @Override
    public Brand save(Brand brand) {
        return brandRepository.save(brand);
    }

    @Override
    public CustomResponse deleteById(Long id) {
        Optional<Brand> brandOptional = brandRepository.findById(id);
        BusinessAssert.isTrue(brandOptional.isPresent(), BusinessExceptionCode.NOT_EXIST, "Không tồn tại");
        brandRepository.deleteById(id);
        return new CustomResponse("Thành công", 1);
    }

    @Override
    public Brand save(BrandDto brandDto) {
        MultipartFile img = brandDto.getImage();
        BusinessAssert.notTrue(img.isEmpty(), BusinessExceptionCode.INVALID_PARAM, "Thiếu file ảnh hãng");
        String fileName = img.getOriginalFilename();
        long currentTime = System.currentTimeMillis();
        fileName = currentTime + "_" + fileName;
        try {
            FileCopyUtils.copy(img.getBytes(), new File(uploadPath + fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Brand brand = new Brand();
        brand.setName(brand.getName());
        brand.setDescription(brandDto.getDescription());
        brand.setImage(fileName);
        brandRepository.save(brand);
        return brand;
    }

    @Override
    public Brand update(Long id, BrandDto brandDto) {
        Optional<Brand> brandOptional = brandRepository.findById(id);
        BusinessAssert.isTrue(brandOptional.isPresent(), BusinessExceptionCode.NOT_EXIST, "Không tồn tại");
        MultipartFile img = brandDto.getImage();
        BusinessAssert.notTrue(img.isEmpty(), BusinessExceptionCode.INVALID_PARAM, "Thiếu file ảnh hãng");
        String fileName = img.getOriginalFilename();
        long currentTime = System.currentTimeMillis();
        fileName = currentTime + "_" + fileName;
        try {
            FileCopyUtils.copy(img.getBytes(), new File(uploadPath + fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Brand brand = new Brand();
        brand.setId(id);
        brand.setName(brand.getName());
        brand.setDescription(brandDto.getDescription());
        brand.setImage(fileName);
        brandRepository.save(brand);
        return brand;
    }
}
