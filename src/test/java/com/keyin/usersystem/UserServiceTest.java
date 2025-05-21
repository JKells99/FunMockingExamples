package com.keyin.usersystem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserServiceTest {

    UserService userService = new UserService(new UserRepoImpl());
    String name;
    String email;
    String password;

    String name1;
    String email2;
    String password3;

    @BeforeEach
    public void setUp() {
        name = "Jordan";
        email = "J_j.com";
        password = "1234";

        name1 = "Jordan1";
        email2 = "J1_j.com";
        password3 = "12234";
    }

    @Test
    public void testRegisterUser() {
        boolean result = userService.registerUser(name, email, password);
        Assertions.assertTrue(result);
    }
    @Test
    void testRegisterUserErrorNoName() {
        User user = new User(null,null,null);
        Assertions.assertFalse(userService.registerUser(user.getName(), user.getEmail(), user.getPassword()));
    }
    @Test
    void testGettingALlUsers(){
        userService.registerUser(name, email, password);
        userService.registerUser(name1, email2, password3);
        Assertions.assertEquals(2, userService.getAllUsers().size());
    }
}
