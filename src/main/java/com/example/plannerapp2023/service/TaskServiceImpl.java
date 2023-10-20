package com.example.plannerapp2023.service;

import com.example.plannerapp2023.domain.entity.TaskEntity;
import com.example.plannerapp2023.domain.serverModel.TaskServiceModel;
import com.example.plannerapp2023.repository.TaskRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final ModelMapper modelMapper;
    private final PriorityService priorityService;

    public TaskServiceImpl(TaskRepository taskRepository, ModelMapper modelMapper, PriorityService priorityService) {
        this.taskRepository = taskRepository;
        this.modelMapper = modelMapper;
        this.priorityService = priorityService;
    }

    @Override
    public void addTask(TaskServiceModel taskServiceModel) {

        TaskEntity taskNew = modelMapper.map(taskServiceModel, TaskEntity.class);

       taskNew.setPriority(priorityService.findTaskByPriorityNameEnum(taskServiceModel.getPriorityNameEnum()));

        taskRepository.save(taskNew);
    }
}
