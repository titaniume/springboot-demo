package com.titaniume.springboot.dao;

import com.titaniume.springboot.bean.User;
import com.titaniume.springboot.util.base.Page;

public interface UserDao {
	
	int insert(User user);
	
	int deleteById(int id);
	
	int updateById(User user);
	
	User selectById(int id);

	
}
