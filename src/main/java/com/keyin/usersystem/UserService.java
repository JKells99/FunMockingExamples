package com.keyin.usersystem;

import java.util.List;

public class UserService {
//    UserRepoImpl userRepository;
     UserRepository userRepository1;

//    public UserService(UserRepoImpl userRepository) {
//        this.userRepository = userRepository;
//    }

    public UserService(UserRepository userRepository) {
        this.userRepository1 = userRepository;
    }

    public boolean registerUser(String name, String email, String password) {
        User user = new User(name, email, password);
        return userRepository1.saveUser(user);
    }
    public List<User> getAllUsers() {
        return userRepository1.getAllUsers();
    }
}
