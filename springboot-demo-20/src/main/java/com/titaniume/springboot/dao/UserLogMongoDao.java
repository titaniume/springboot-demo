package com.titaniume.springboot.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.titaniume.springboot.bean.UserLog;

/**
 * MongoDB 继承MongoRepository 
 * 和jpa操作相关一样
 * @author titaniume
 * 2017年12月10日下午1:05:00
 *
 */
public interface UserLogMongoDao extends MongoRepository<UserLog, Integer> {
	
	UserLog findById(Integer id);
	
	List<UserLog> findByUserNameAndUserIp(String name, String ip);
	
	Page<UserLog> findByUserName(String name, Pageable pageable);
}
