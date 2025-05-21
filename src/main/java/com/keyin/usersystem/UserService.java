package com.keyin.usersystem;

import java.util.List;

public class UserService {
    UserRepoImpl userRepository;

    public UserService(UserRepoImpl userRepository) {
        this.userRepository = userRepository;
    }

    public boolean registerUser(String name, String email, String password) {
        User user = new User(name, email, password);
        return userRepository.saveUser(user);
    }
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }
}
