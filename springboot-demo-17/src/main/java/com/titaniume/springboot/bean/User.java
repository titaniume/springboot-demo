package com.titaniume.springboot.bean;

import java.util.Date;

/**
 * 实体类
 * @author titaniume
 * 2017年12月8日下午12:20:05
 *
 */
public class User {
	
	private int id;
	private String name;
	private Date  createTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", createTime=" + createTime + "]";
	}
	
	
}
