package com.example.plannerapp2023.repository;

import com.example.plannerapp2023.domain.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Long> {

List<TaskEntity>findAllByUser_Id(Long user_id);

}
