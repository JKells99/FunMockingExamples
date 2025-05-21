package com.keyin.usersystem;

import java.util.ArrayList;
import java.util.List;

public class UserRepoImpl implements UserRepository{
    ArrayList<User> users = new ArrayList<>();


    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    @Override
    public boolean saveUser(User user) {
        if(user.getName() == null || user.getEmail() == null || user.getPassword() == null) {
            return false;
        }
        users.add(user);
        return true;
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }
}
