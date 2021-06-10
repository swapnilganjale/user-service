package com.project.platform.service;

import com.project.platform.model.User;
import com.project.platform.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void  getUsers_basic(){
        when(userRepository.findAll()).thenReturn(Arrays.asList(new User(1,"swap","ganjale")));
        List<User> users = userService.getUsers();
        assertEquals(1, users.get(0).getId());
    }

    @Test
    public void  saveUser_basic(){
        User user = new User(1,"swap","ganjale");
        when(userRepository.save(user)).thenReturn(user);
        User userObj = userService.save(user);
        Assertions.assertEquals(user.getUserName(), userObj.getUserName());
    }

    @Test
    public void  getUser_basic(){
        Optional<User> user = Optional.of(new User(1, "swap", "ganjale"));
        when(userRepository.findById(1)).thenReturn(user);
        User userObj = userService.getUser(user.get().getId());
        Assertions.assertEquals(user.get().getUserName(), userObj.getUserName());
    }
}
