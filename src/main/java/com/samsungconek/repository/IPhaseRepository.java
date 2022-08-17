package com.samsungconek.repository;

import com.samsungconek.model.entity.Phase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPhaseRepository extends JpaRepository<Phase, Long> {
}
