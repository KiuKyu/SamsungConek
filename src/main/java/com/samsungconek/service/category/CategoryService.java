package com.samsungconek.service.category;

import com.samsungconek.model.entity.Category;
import com.samsungconek.repository.ICategoryRepository;
import com.samsungconek.utils.CustomResponse;
import com.samsungconek.utils.exception.BusinessAssert;
import com.samsungconek.utils.exception.BusinessExceptionCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        List<Category> categoryList = categoryRepository.findAll();
        BusinessAssert.isTrue(categoryList.size() > 0, BusinessExceptionCode.EMPTY_LIST, "Danh sách rỗng");
        return categoryList;
    }

    @Override
    public Category findById(Long id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        BusinessAssert.isTrue(categoryOptional.isPresent(), BusinessExceptionCode.NOT_EXIST, "Không tồn tại");
        return categoryOptional.get();
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public CustomResponse deleteById(Long id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        BusinessAssert.isTrue(categoryOptional.isPresent(), BusinessExceptionCode.NOT_EXIST, "Không tồn tại");
        categoryRepository.deleteById(id);
        return new CustomResponse("Thành công", 1);
    }

    @Override
    public Page<Category> findAll(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    @Override
    public List<Category> findAllByParentCategoryIsNull() {
        List<Category> categoryList = categoryRepository.findAllByParentCategoryIsNull();
        BusinessAssert.isTrue(categoryList.size() > 0, BusinessExceptionCode.EMPTY_LIST, "Danh sách rỗng");
        return categoryList;
    }

    @Override
    public Category update(Long id, Category newCategory) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        BusinessAssert.isTrue(categoryOptional.isPresent(), BusinessExceptionCode.NOT_EXIST, "Không tồn tại");
        return categoryRepository.save(newCategory);
    }
}
