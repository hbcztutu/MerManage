package com.tzm.pojo;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.IdType;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 *
 * 
 *
 */
@TableName("u_user")
public class User implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/**  */
	@TableId(type = IdType.AUTO)
	private Long id;

	/** 用户昵称 */
	private String username;

	/** 邮箱|登录帐号 */
	private String email;

	/** 密码 */
	private String logpwd;

	/** 创建时间 */
	private Date creattime;

	/** 最后登录时间 */
	private Date lastlogintime;

	/** 1:有效，0:禁止登录 */
	private Long status;

	/** 1锁定，0 正常 */
	private Long locked;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogpwd() {
		return this.logpwd;
	}

	public void setLogpwd(String logpwd) {
		this.logpwd = logpwd;
	}

	public Date getCreattime() {
		return this.creattime;
	}

	public void setCreattime(Date creattime) {
		this.creattime = creattime;
	}

	public Date getLastlogintime() {
		return this.lastlogintime;
	}

	public void setLastlogintime(Date lastlogintime) {
		this.lastlogintime = lastlogintime;
	}

	public Long getStatus() {
		return this.status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public Long getLocked() {
		return this.locked;
	}

	public void setLocked(Long locked) {
		this.locked = locked;
	}

}
