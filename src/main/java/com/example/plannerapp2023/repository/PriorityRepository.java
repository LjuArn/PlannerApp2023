package com.example.plannerapp2023.repository;

import com.example.plannerapp2023.domain.entity.PriorityEntity;
import com.example.plannerapp2023.domain.entity.enums.PriorityEnumName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PriorityRepository extends JpaRepository<PriorityEntity, Long> {

    Optional<PriorityEntity>findByPriorityName(PriorityEnumName priorityName);
}
