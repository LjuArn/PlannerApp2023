package com.example.plannerapp2023.domain.serverModel;

import com.example.plannerapp2023.domain.entity.enums.PriorityEnumName;
import jakarta.validation.constraints.Future;

import java.time.LocalDate;

public class TaskServiceModel {


    private Long id;
    private String description;
    private LocalDate dueDate;
    private PriorityEnumName priorityNameEnum;

    public TaskServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public TaskServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public TaskServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public TaskServiceModel setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public PriorityEnumName getPriorityNameEnum() {
        return priorityNameEnum;
    }

    public TaskServiceModel setPriorityNameEnum(PriorityEnumName priorityNameEnum) {
        this.priorityNameEnum = priorityNameEnum;
        return this;
    }
}
