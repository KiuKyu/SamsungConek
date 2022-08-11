package com.samsungconek.repository;

import com.samsungconek.model.entity.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILoggerRepository extends JpaRepository<Logger, Long> {
    Page<Logger> findAll(Pageable pageable);

//    Page<Logger> findAllByUser(Pageable pageable, User user);
}
