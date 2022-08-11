package com.samsungconek.service.category;

import com.samsungconek.model.entity.Category;
import com.samsungconek.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICategoryService extends IGeneralService<Category> {
    Page<Category> findAll(Pageable pageable);

    Iterable<Category> findAllByParentCategoryIsNull();
}
