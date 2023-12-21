package com.account.repository;

import com.account.entity.MovementType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovementTypeRepository extends JpaRepository<MovementType, Integer> {
}
