package com.titaniume.springboot;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.test.context.junit4.SpringRunner;

import com.titaniume.springboot.bean.User;
import com.titaniume.springboot.bean.UserLog;
import com.titaniume.springboot.component.TitaniumeMongodbComponent;
import com.titaniume.springboot.dao.UserLogMongoDao;



/**
 * 测试MongoDB  
 * 继承MongoRepository
 * @author titaniume 
 * 2017年12月10日下午12:13:53
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootDemo20ApplicationTests_2 {

	@Autowired
	private UserLogMongoDao userLogMongoDao;
	
	//这种方式新增若ID相同不会报错，会替换掉上一个Id一样的值
	@Test
	public void insert() {
		UserLog user = new UserLog();
		user.setId(5);
		user.setUserName("abc2");
		user.setUserIp("127.0.0.3");
		user.setCreateTime(new Date());
		userLogMongoDao.save(user);
	}

	@Test
	public void delete() {
		userLogMongoDao.delete(1);
	}
	
	//修改数据若ID不存在的就会新增这条数据
	@Test
	public void update() {
		UserLog user = new UserLog();
		user.setId(2);
		user.setUserName("efg1");
		user.setUserIp("192.168.0.4");
		user.setCreateTime(new Date());
		userLogMongoDao.save(user);
	}

	@Test
	public void select1() {
		UserLog result = userLogMongoDao.findOne(2);
		System.out.println(result);
	}
	
	
	@Test
	public void select2() {
		UserLog result = userLogMongoDao.findById(2);
		System.out.println(result);
	}

	@Test
	public void select3() {
		List<UserLog> result = userLogMongoDao.findByUserNameAndUserIp("titaniume2", "192.168.0.1");
		System.out.println(result);
	}

	@Test
	public void queryForPage() {
		Pageable pageable = new PageRequest(0, 20, new Sort(new Order(Direction.DESC, "id")));
		
		//Page<UserLog> result =userLogMongoDao.findByUserName("titaniume2", pageable);
		Page<UserLog> result =userLogMongoDao.findAll(pageable);
		System.out.println(result.getContent());
	}
	
}
