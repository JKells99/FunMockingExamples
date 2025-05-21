package com.keyin.usersystem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    public void testUserCreate(){
        User user = new User("Jordan","J_j.com","1234");

        Assertions.assertEquals("Jordan", user.getName());

    }

    @Test
    void testUserUpdate(){
        User user = new User("Jordan","J_j.com","1234");
        user.setName("Billy");

        Assertions.assertEquals("Billy", user.getName());

    }

    @Test
    void testUserDelete(){
        User user = new User("Jordan","J_j.com","1234");
        user.setName(null);
        user.setEmail(null);
        user.setPassword(null);

        Assertions.assertNull(user.getName());
        Assertions.assertNull(user.getEmail());
        Assertions.assertNull(user.getPassword());

    }


}
