package com.tzm.service.impl;

import org.springframework.stereotype.Service;

import com.tzm.Dao.UserDao;
import com.tzm.pojo.User;
import com.tzm.service.UserService;
import com.baomidou.framework.service.impl.SuperServiceImpl;

/**
 *
 * User 表数据服务层接口实现类
 *
 */
@Service
public class UserServiceImpl extends SuperServiceImpl<UserDao, User> implements UserService {


}