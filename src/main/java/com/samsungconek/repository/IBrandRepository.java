package com.samsungconek.repository;

import com.samsungconek.model.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IBrandRepository extends JpaRepository<Brand, Long> {
//    @Query(value = "SELECT COUNT(*) FROM BRANDS", nativeQuery = true)
//    int checkRow();
}
