package com.samsungconek.repository;

import com.samsungconek.model.entity.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPartRepository extends JpaRepository<Part, Long> {
}
