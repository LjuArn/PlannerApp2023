package com.example.plannerapp2023.service;

import com.example.plannerapp2023.domain.entity.TaskEntity;
import com.example.plannerapp2023.domain.entity.UserEntity;
import com.example.plannerapp2023.domain.serverModel.TaskServiceModel;
import com.example.plannerapp2023.domain.viewModel.TaskViewModel;
import com.example.plannerapp2023.repository.TaskRepository;
import com.example.plannerapp2023.repository.UserRepository;
import com.example.plannerapp2023.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final ModelMapper modelMapper;
    private final PriorityService priorityService;
    private final UserRepository userRepository;
    private final CurrentUser currentUser;

    public TaskServiceImpl(TaskRepository taskRepository, ModelMapper modelMapper, PriorityService priorityService, UserRepository userRepository, CurrentUser currentUser) {
        this.taskRepository = taskRepository;
        this.modelMapper = modelMapper;
        this.priorityService = priorityService;
        this.userRepository = userRepository;
        this.currentUser = currentUser;
    }

    @Override
    public void addTask(TaskServiceModel taskServiceModel) {

        TaskEntity taskNew = modelMapper.map(taskServiceModel, TaskEntity.class);
        taskNew.setPriority(priorityService.findTaskByPriorityNameEnum(taskServiceModel.getPriorityNameEnum()));

        taskRepository.save(taskNew);
    }

    @Override
    public Long countTasks(Long curUserId) {
        return findAllTasksNoUser(curUserId).stream().count();
    }

    @Override
    public List<TaskViewModel> findAllTasksNoUser(Long curUserId) {
        return taskRepository.findAllByUser_Id(null)
                .stream()
                .map(taskEntity -> modelMapper.map(taskEntity, TaskViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<TaskViewModel> findAllMyTasks(Long curUserId) {
        return taskRepository.findAllByUser_Id(curUserId)
                .stream()
                .map(taskEntity -> modelMapper.map(taskEntity, TaskViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void assaignMeTask(Long id) {

        TaskEntity task = taskRepository.findById(id).orElse(null);
        UserEntity findUserOnTask = userRepository.findById(currentUser.getId()).orElse(null);
        TaskEntity taskAssigned = task.setUser(findUserOnTask);

        taskRepository.save(taskAssigned);

    }

    @Override
    public void returnTask(Long id) {
        TaskEntity task = taskRepository.findById(id).orElse(null);
        TaskEntity taskWithNoUser = task.setUser(null);

        taskRepository.save(taskWithNoUser);
    }


    @Override
    public void del(Long id) {
        taskRepository.deleteById(id);
    }


}
