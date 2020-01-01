package com.arnold.shardingjdbc.UserEncrypt.service.impl;

import com.arnold.shardingjdbc.UserEncrypt.entity.User;
import com.arnold.shardingjdbc.UserEncrypt.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    IUserService userService;

    @Test
    public void test() {
        User user = new User();
        user.setUserDecrypt("testtest");
        userService.save(user);
    }

}