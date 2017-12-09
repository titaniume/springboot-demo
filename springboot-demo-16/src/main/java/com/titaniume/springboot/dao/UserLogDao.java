/**
 * titaniume
 * 2017年12月9日上午11:23:39
 */
package com.titaniume.springboot.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.titaniume.springboot.bean.UserLog;

/**
 * 接口
 * @author titaniume
 * 2017年12月9日上午11:23:39
 * 
 */
public interface UserLogDao extends JpaRepository<UserLog, Integer> {
	
	
	/**
	 * 使用内置的关键词查询 
	 * findById ---->findBy+(表字段)  
	 * findByLastnameAndFirstname --->或者findBy+(表字段+关键字+表字段)等等，这里可以看官方手册
	 * https://docs.spring.io/spring-data/jpa/docs/1.10.2.RELEASE/reference/html/ 
	 * @param name
	 * @param pageable 
	 * @return
	 */
	UserLog findById(int id);
	
	List<UserLog> findByUserNameAndUserIp(String name, String ip);
	
	/**
	 * 使用自定义语句查询--优先级比上面的高
	 * 这里的SQL语句是HQL语句
	 * 跳过findByUserIp的规则,会优先执行@Query("XXX")
	 * @param ip
	 * @return
	 */
	@Query("select u from UserLog u where u.userIp=?1")
	List<UserLog> findByUserIp(String ip);
	
	/**
	 * 分页
	 * @param name 名字 
	 * @param pageable
	 * @return
	 */
	Page<UserLog> findByUserName(String name, Pageable pageable);


	

}
