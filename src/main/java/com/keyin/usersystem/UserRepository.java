package com.keyin.usersystem;

import java.util.ArrayList;
import java.util.List;

public interface UserRepository {
    boolean saveUser(User user); //<-- Pretend that these make a db call for us
    List<User> getAllUsers();//<-- Pretend that these make a db call for us

}
