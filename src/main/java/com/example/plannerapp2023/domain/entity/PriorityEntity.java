package com.example.plannerapp2023.domain.entity;


import com.example.plannerapp2023.domain.entity.enums.PriorityEnumName;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "priorities")
public class PriorityEntity extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private PriorityEnumName priorityName;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @OneToMany(mappedBy = "priority", fetch = FetchType.EAGER)
    private Set<TaskEntity> tasks;


    public PriorityEntity() {
    }

    public PriorityEnumName getPriorityName() {
        return priorityName;
    }

    public PriorityEntity setPriorityName(PriorityEnumName priorityName) {
        this.priorityName = priorityName;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public PriorityEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public Set<TaskEntity> getTasks() {
        return tasks;
    }

    public PriorityEntity setTasks(Set<TaskEntity> tasks) {
        this.tasks = tasks;
        return this;
    }
}
//•	Has a Priority name (unique, not null)
//o	an option between (URGENT, IMPORTANT, LOW)

//•	Has a Description  (not null)
//o	For URGENT - "An urgent problem that blocks the system use until the issue is resolved."
//o	For IMPORTANT – "A core functionality that your product is explicitly supposed to perform is compromised."
//o	For LOW – "Should be fixed if time permits but can be postponed."


//•	Has collection of Tasks
//o	One priority may have many tasks, but one task has only one priority.