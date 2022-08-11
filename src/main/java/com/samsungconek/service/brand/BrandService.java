package com.samsungconek.service.brand;

import com.samsungconek.model.entity.Brand;
import com.samsungconek.repository.IBrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BrandService implements IBrandService {
    @Autowired
    private IBrandRepository brandRepository;

    @Override
    public Iterable<Brand> findAll() {
        return brandRepository.findAll();
    }

    @Override
    public Optional<Brand> findById(Long id) {
        return brandRepository.findById(id);
    }

    @Override
    public Brand save(Brand brand) {
        return brandRepository.save(brand);
    }

    @Override
    public void deleteById(Long id) {
        brandRepository.deleteById(id);
    }
}
