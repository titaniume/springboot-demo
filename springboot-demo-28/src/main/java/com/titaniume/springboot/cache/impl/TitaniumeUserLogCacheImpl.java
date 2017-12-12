package com.titaniume.springboot.cache.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.titaniume.springboot.bean.UserLog;
import com.titaniume.springboot.cache.TitaniumeUserLogCache;
import com.titaniume.springboot.dao.UserLogDao;

@CacheConfig(cacheNames = "titaniumeCache")
@Repository
public class TitaniumeUserLogCacheImpl implements TitaniumeUserLogCache {
	
	@Autowired
	private UserLogDao userLogDao;

	@Cacheable(key = "#p0")
	@Override
	public UserLog selectById(Integer id) {
		System.out.println("查询功能，缓存找不到，直接读库, id=" + id);
		return userLogDao.findOne(id);
	}

	@CachePut(key = "#p0")
	@Override
	public UserLog updateById(UserLog userLog) {
		System.out.println("更新功能，更新缓存，直接写库, id=" + userLog);
		return userLogDao.save(userLog);
	}

	@CacheEvict(key = "#p0")
	@Override
	public String deleteById(Integer id) {
		System.out.println("删除功能，删除缓存，直接写库, id=" + id);
		return "清空缓存成功";
	}
}