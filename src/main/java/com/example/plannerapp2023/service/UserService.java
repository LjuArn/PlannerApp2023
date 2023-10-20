package com.example.plannerapp2023.service;

import com.example.plannerapp2023.domain.serverModel.UserServiceModel;

public interface UserService {
    void registerUser(UserServiceModel userServiceModel);

    boolean isNameExistMetod(String username);

    UserServiceModel findUserByUserNameAndPassword(String username, String password);

    void loginUser(Long id, String username);

    void logOutUser();
}
