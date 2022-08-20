package com.samsungconek.service.brand;

import com.samsungconek.model.dto.BrandDto;
import com.samsungconek.model.entity.Brand;
import com.samsungconek.service.IGeneralService;

public interface IBrandService extends IGeneralService<Brand> {
    Brand save(BrandDto brandDto);

    Brand update(Long id, BrandDto brandDto);
}
