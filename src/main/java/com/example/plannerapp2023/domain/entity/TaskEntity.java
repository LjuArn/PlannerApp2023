package com.example.plannerapp2023.domain.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "tasks")
public class TaskEntity extends BaseEntity {

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;
    @Column(nullable = false)
    private LocalDate dueDate;

    @ManyToOne
    private PriorityEntity priority;

    @ManyToOne
    private UserEntity user;

    public TaskEntity() {
    }

    public String getDescription() {
        return description;
    }

    public TaskEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public TaskEntity setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public PriorityEntity getPriority() {
        return priority;
    }

    public TaskEntity setPriority(PriorityEntity priority) {
        this.priority = priority;
        return this;
    }

    public UserEntity getUser() {
        return user;
    }

    public TaskEntity setUser(UserEntity user) {
        this.user = user;
        return this;
    }
}
//•	Has a Description (not null)
//o	Description length must be between 2 and 50 characters (inclusive of 2 and 50).

//•	Has a dueDate (not null) - date
//o	The dueDate must be a positive in the future.


//•	Has a Priority (not null)
//o	One task has one priority and one priority can have many tasks.

//•	Has a User
//o	The user who has assigned the task to him so he can work on the task.
// One task has one user, but one user may have many tasks.

