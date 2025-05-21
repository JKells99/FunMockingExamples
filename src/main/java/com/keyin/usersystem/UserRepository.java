package com.keyin.usersystem;

import java.util.ArrayList;
import java.util.List;

public interface UserRepository {
    boolean saveUser(User user);
     List<User> getAllUsers();

}
