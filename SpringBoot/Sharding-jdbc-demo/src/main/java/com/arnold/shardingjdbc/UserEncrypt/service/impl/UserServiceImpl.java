package com.arnold.shardingjdbc.UserEncrypt.service.impl;

import com.arnold.shardingjdbc.UserEncrypt.entity.User;
import com.arnold.shardingjdbc.UserEncrypt.mapper.UserMapper;
import com.arnold.shardingjdbc.UserEncrypt.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author arnold
 * @since 2019-12-31
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
