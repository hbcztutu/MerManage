package com.tzm.pojo;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.IdType;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 *
 * 
 *
 */
@TableName("u_role_permission")
public class RolePermission implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/** 角色ID */
	private Long rid;

	/** 权限ID */
	private Long pid;

	public Long getRid() {
		return this.rid;
	}

	public void setRid(Long rid) {
		this.rid = rid;
	}

	public Long getPid() {
		return this.pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

}
