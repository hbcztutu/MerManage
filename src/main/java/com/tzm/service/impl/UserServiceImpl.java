package com.tzm.service.impl;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.baomidou.framework.service.impl.SuperServiceImpl;
import com.tzm.Dao.UserDao;
import com.tzm.pojo.User;
import com.tzm.service.UserService;

/**
 *
 * User 表数据服务层接口实现类
 *
 */

@Service("UserServiceImpl")
public class UserServiceImpl extends SuperServiceImpl<UserDao, User> implements UserService {

  
  @Override
  public Set<String> findRoles(String username) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Set<String> findPermissions(String username) {
    // TODO Auto-generated method stub
    return null;
  }



}