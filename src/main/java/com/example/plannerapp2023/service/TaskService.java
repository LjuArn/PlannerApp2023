package com.example.plannerapp2023.service;

import com.example.plannerapp2023.domain.serverModel.TaskServiceModel;
import com.example.plannerapp2023.domain.viewModel.TaskViewModel;

import java.util.List;

public interface TaskService {
    void addTask(TaskServiceModel taskServiceModel);

    Long countTasks(Long curUserId);

    List<TaskViewModel> findAllTasksNoUser(Long curUserId);

    List<TaskViewModel> findAllMyTasks(Long curUserId);

    void assaignMeTask(Long id);

    void del(Long id);

    void returnTask(Long id);
}
