package com.arnold.febs.system.service.impl;

import com.arnold.febs.common.consts.FebsConstant;
import com.arnold.febs.common.exception.FebsException;
import com.arnold.febs.common.utils.CheckUtil;
import com.arnold.febs.common.utils.PasswordHelper;
import com.arnold.febs.system.entity.User;
import com.arnold.febs.system.entity.UserRole;
import com.arnold.febs.system.enums.UserStateEnum;
import com.arnold.febs.system.mapper.UserMapper;
import com.arnold.febs.system.service.IUserRoleService;
import com.arnold.febs.system.service.IUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static com.arnold.febs.common.utils.CheckUtil.*;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author ARNOLD
 * @since 2020-02-06
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    PasswordHelper passwordHelper;

    @Autowired
    IUserRoleService userRoleService;

    @Override
    public User findUserByName(String name) {
        notNull(name,"name.is.null");
        User userquery = new User();
        userquery.setUsername(name);
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>(userquery);
        User user = userMapper.selectOne(userQueryWrapper);
        return user;
    }

    @Override
    public void createUser(User user) {
        User userByName = findUserByName(user.getUsername());
        if (userByName != null) {
            throw new FebsException("用户已存在");
        }
        user.setCreateTime(LocalDateTime.now());
        user.setStatus(UserStateEnum.NORMAL);
        passwordHelper.encryptPassword(user);
        save(user);
        if (StringUtils.isBlank(user.getRoleId())) {
            user.setRoleId(String.valueOf(FebsConstant.REGISTER_ROLE_ID));
        }
        String[] roles = user.getRoleId().split(",");
        setUserRoles(user, roles);
    }

    public void setUserRoles(User user, String[] roles) {
        List<UserRole> userRoles = new ArrayList<>();
        Arrays.stream(roles).forEach(roleId ->{
            UserRole userRole = new UserRole();
            userRole.setUserId(user.getUserId());
            userRole.setRoleId(Long.valueOf(roleId));
            userRoles.add(userRole);
        });
        userRoleService.saveBatch(userRoles);
    }
}
