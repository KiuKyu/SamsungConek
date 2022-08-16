package com.samsungconek.repository;

import com.samsungconek.model.entity.Shipping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IShippingRepository extends JpaRepository<Shipping, Long> {
}
