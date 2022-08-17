package com.samsungconek.repository;

import com.samsungconek.model.entity.Footer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFooterRepository extends JpaRepository<Footer, Long> {
}
