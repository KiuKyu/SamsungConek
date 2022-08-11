package com.samsungconek.repository;

import com.samsungconek.model.entity.Category;
import com.samsungconek.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "SELECT * FROM PRODUCT p JOIN PRODUCT_CATEGORY pc ON p.ID = pc.PRODUCT_ID " +
            "WHERE CATEGORIES_ID IN (:categoryIdList) OFFSET 0", nativeQuery = true)
    Iterable<Product> findProductsByCategoryIdList(
            @Param(value = "categoryIdList") String categoryIdList
    );
}
