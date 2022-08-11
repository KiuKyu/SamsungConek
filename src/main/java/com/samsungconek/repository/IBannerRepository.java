package com.samsungconek.repository;

import com.samsungconek.model.entity.Banner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBannerRepository extends JpaRepository<Banner, Long> {

}
