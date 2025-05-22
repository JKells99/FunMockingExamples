package com.keyin.usersystem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class UserRepoTest {


    private UserService userService;

    @Mock
    private UserRepository userRepository;

    User user,user1,user2;

    @BeforeEach
    public void setUp() {
         user = new User("Jordan","J_j.com","1234");
         user1 = new User("Jordan","J_j.com","1234");
         user2 = new User("Jordan","J_j.com","1234");
        MockitoAnnotations.openMocks(this);
        userService = new UserService(userRepository);

    }

    @Test
    public void testRegisterUser() {
        String name = "Jordan";
        String email = "J_j.com";
        String password = "1234";
        when(userRepository.saveUser(any(User.class))).thenReturn(true);
        boolean result = userService.registerUser(name, email, password);
        Assertions.assertTrue(result);


    }

    @Test
    void testRegisterUserErrorNoName() {
        User user = new User(null,null,null);
        when(userRepository.saveUser(any(User.class))).thenReturn(false);
        Assertions.assertFalse(userService.registerUser(user.getName(), user.getEmail(), user.getPassword()));
    }

    @Test
    void testGettingALlUsers(){
        when(userRepository.getAllUsers()).thenReturn(List.of(user,user1,user2));
        Assertions.assertEquals(3, userService.getAllUsers().size());
        Assertions.assertTrue(userService.getAllUsers().contains(user));
        Assertions.assertTrue(userService.getAllUsers().contains(user1));
    }


}
