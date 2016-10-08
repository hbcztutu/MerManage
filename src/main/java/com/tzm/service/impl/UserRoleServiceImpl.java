package com.tzm.service.impl;

import org.springframework.stereotype.Service;

import com.tzm.Dao.UserRoleDao;
import com.tzm.pojo.UserRole;
import com.tzm.service.UserRoleService;
import com.baomidou.framework.service.impl.SuperServiceImpl;

/**
 *
 * UserRole 表数据服务层接口实现类
 *
 */
@Service
public class UserRoleServiceImpl extends SuperServiceImpl<UserRoleDao, UserRole> implements UserRoleService {


}