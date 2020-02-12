package com.arnold.febs.system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.arnold.febs.common.controller.CurdController;
import com.arnold.febs.system.entity.UserRole;

/**
 * <p>
 * 用户角色关联表 控制器
 * </p>
 *
 * @author ARNOLD
 * @since 2020-02-12
*/
@RestController
@RequestMapping("/system/user-role")
public class UserRoleController extends CurdController<UserRole> {

}
