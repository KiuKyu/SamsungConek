package com.samsungconek.repository;

import com.samsungconek.model.entity.Spec;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISpecRepository extends JpaRepository<Spec, Long> {

}
