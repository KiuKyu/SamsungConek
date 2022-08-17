package com.samsungconek.service.brand;

import com.samsungconek.model.entity.Brand;
import com.samsungconek.repository.IBrandRepository;
import com.samsungconek.utils.exception.BusinessAssert;
import com.samsungconek.utils.exception.BusinessExceptionCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandService implements IBrandService {
    @Autowired
    private IBrandRepository brandRepository;

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
    public void deleteById(Long id) {
        Optional<Brand> brandOptional = brandRepository.findById(id);
        BusinessAssert.isTrue(brandOptional.isPresent(), BusinessExceptionCode.NOT_EXIST, "Không tồn tại");
        brandRepository.deleteById(id);
    }
}
