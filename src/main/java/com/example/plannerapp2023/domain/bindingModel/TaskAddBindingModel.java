package com.example.plannerapp2023.domain.bindingModel;


import com.example.plannerapp2023.domain.entity.enums.PriorityEnumName;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

public class TaskAddBindingModel {


    @Size(min = 2, max = 50, message = "Description length must be between 2 and 50 characters.")
    private String description;
    @Future(message = "Due Date mast be in the future")
    private LocalDate dueDate;
    @NotNull(message = "You mast select a priority")
    private PriorityEnumName priorityNameEnum;

    public TaskAddBindingModel() {
    }

    public String getDescription() {
        return description;
    }

    public TaskAddBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public TaskAddBindingModel setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public PriorityEnumName getPriorityNameEnum() {
        return priorityNameEnum;
    }

    public TaskAddBindingModel setPriorityNameEnum(PriorityEnumName priorityNameEnum) {
        this.priorityNameEnum = priorityNameEnum;
        return this;
    }
}
