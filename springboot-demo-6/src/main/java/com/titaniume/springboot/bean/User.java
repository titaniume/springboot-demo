package com.titaniume.springboot.bean;

import java.util.Date;

/**
 * 实体类
 * @author titaniume
 * 2017年12月6日上午1:25:49
 *
 */
public class User {
	private int id;
	private String name;
	private Date date;
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}
