package com.samsungconek.repository;

import com.samsungconek.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Long> {
    Iterable<Category> findAllByParentCategoryIsNull();
}
