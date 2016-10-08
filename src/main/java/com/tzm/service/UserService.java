package com.tzm.service;

import java.util.Set;

import com.baomidou.framework.service.ISuperService;
import com.tzm.pojo.User;

/**
 *
 * User 表数据服务层接口
 *
 */
public interface UserService extends ISuperService<User> {

  public Set<String> findRoles(String username);
  public Set<String> findPermissions(String username);
}