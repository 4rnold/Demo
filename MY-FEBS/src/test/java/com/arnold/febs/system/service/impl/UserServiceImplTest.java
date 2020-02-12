package com.arnold.febs.system.service.impl;

import com.arnold.febs.common.utils.CheckUtil;
import com.arnold.febs.system.entity.User;
import com.arnold.febs.system.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Locale;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    IUserService userService;

    @Test
    public void findUserByName() {
        User mrBird = userService.findUserByName("MrBird");
        System.out.println(mrBird);
    }

    @Autowired
    MessageSource messageSource;

    @Test
    public void test(){
        String message = messageSource.getMessage("value.is.null", null, Locale.ITALY);
        System.out.println(message);
    }

    @Test
    public void test2() {
        try {
            CheckUtil.notNull(null,"value.is.null",null);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}