package com.arnold.shardingjdbc.UserEncrypt.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.arnold.shardingjdbc.common.controller.CurdController;
import com.arnold.shardingjdbc.UserEncrypt.entity.User;

/**
 * <p>
 *  控制器
 * </p>
 *
 * @author arnold
 * @since 2019-12-31
*/
@RestController
@RequestMapping("/Userncrypt/user")
public class UserController extends CurdController<User> {

}
