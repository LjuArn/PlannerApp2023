package com.example.plannerapp2023.domain.viewModel;

import com.example.plannerapp2023.domain.entity.UserEntity;
import com.example.plannerapp2023.domain.entity.enums.PriorityEnumName;

import java.time.LocalDate;

public class TaskViewModel {

    private Long id;
    private String description;
    private LocalDate dueDate;
    private PriorityEnumName priorityEnumName;
    private UserEntity user;

    public TaskViewModel() {
    }


    public Long getId() {
        return id;
    }

    public TaskViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public TaskViewModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public TaskViewModel setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public PriorityEnumName getPriorityEnumName() {
        return priorityEnumName;
    }

    public TaskViewModel setPriorityEnumName(PriorityEnumName priorityEnumName) {
        this.priorityEnumName = priorityEnumName;
        return this;
    }

    public UserEntity getUser() {
        return user;
    }

    public TaskViewModel setUser(UserEntity user) {
        this.user = user;
        return this;
    }
}
