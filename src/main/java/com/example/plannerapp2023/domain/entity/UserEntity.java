package com.example.plannerapp2023.domain.entity;


import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity{

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;
    @Column(unique = true, nullable = false)
    private String email;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Set<TaskEntity> assignedTasks;

    public UserEntity() {
    }

    public String getUsername() {
        return username;
    }

    public UserEntity setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public Set<TaskEntity> getAssignedTasks() {
        return assignedTasks;
    }

    public UserEntity setAssignedTasks(Set<TaskEntity> assignedTasks) {
        this.assignedTasks = assignedTasks;
        return this;
    }
}
//•	Has a Username (unique, not null)
//o	Username length must be between 3 and 20 characters (inclusive of 3 and 20).

//•	Has a Password (not null)
//o	Password length must be between 3 and 20 characters (inclusive of 3 and 20).

//•	Has an Email (unique, not null)
//o	Must contain '@'.



//•	Has assignedTasks
//o	The assignedTasks is a collection that contains users tasks that are assigned to him.
// One user may have many tasks and one task can be assigned to only one user.