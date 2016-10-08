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
@TableName("u_user_role")
public class UserRole implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/** 用户ID */
	private Long uid;

	/** 角色ID */
	private Long rid;

	public Long getUid() {
		return this.uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public Long getRid() {
		return this.rid;
	}

	public void setRid(Long rid) {
		this.rid = rid;
	}

}
