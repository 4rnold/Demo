package com.arnold.febs.system.service.impl;

import com.arnold.febs.system.entity.UserRole;
import com.arnold.febs.system.mapper.UserRoleMapper;
import com.arnold.febs.system.service.IUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户角色关联表 服务实现类
 * </p>
 *
 * @author ARNOLD
 * @since 2020-02-12
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

}
