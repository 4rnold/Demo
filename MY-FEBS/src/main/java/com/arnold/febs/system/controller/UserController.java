package com.arnold.febs.system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.arnold.febs.common.controller.CurdController;
import com.arnold.febs.system.entity.User;

/**
 * <p>
 * 用户表 控制器
 * </p>
 *
 * @author ARNOLD
 * @since 2020-02-06
*/
@RestController
@RequestMapping("/system/user")
public class UserController extends CurdController<User> {

}
