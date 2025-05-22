package com.keyin.usersystem;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    boolean saveUser(User user) //<-- Pretend that these make a db call for us
    {
        if (user.getName() == null || user.getEmail() == null || user.getPassword() == null) {
            return false;
        }
        if(user.getName().isEmpty() || user.getEmail().isEmpty() || user.getPassword().isEmpty()) {
            return false;
        }
        // Simulate saving the user to a database
        // In a real implementation, you would save the user to a database here
        // For this example, we'll just print the user details
        System.out.println("Saving user: " + user.getName() + ", " + user.getEmail() + ", " + user.getPassword());
        return true;
    }

    List<User> getAllUsers()//<-- Pretend that these make a db call for us
    {
        return List.of(
                new User("Jordan", "J_j.com", "1234"),
                new User("Jordan1", "J1_j.com", "12234")
        )   ;
    }

}
