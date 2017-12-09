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

import com.titaniume.springboot.bean.UserLog;
import com.titaniume.springboot.dao.UserLogDao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootDemo16ApplicationTests {

	@Autowired
	private UserLogDao userLogDao;
	
	//JpaRepository 接口自带的查询
	@Test
	public void insert() {
		UserLog user = new UserLog();
		user.setUserName("titaniume2");
		user.setUserIp("127.0.0.1");
		user.setCreateTime(new Date());
		userLogDao.save(user);
	}

	@Test
	public void delete() {
		userLogDao.delete(2);
	}

	@Test
	public void update() {
		UserLog user = new UserLog();
		user.setId(3);
		user.setUserName("titaniume2");
		user.setUserIp("192.168.0.1");
		user.setCreateTime(new Date());
		userLogDao.save(user);
	}

	@Test
	public void select1() {
		UserLog result = userLogDao.findOne(3);
		System.out.println(result);
	}
	//扩展进行自定义的查询
	//1,使用内置关键字查询
	@Test
	public void select2() {
		UserLog result = userLogDao.findById(3);
		System.out.println(result);
	}

	@Test
	public void select3() {
		List<UserLog> result = userLogDao.findByUserNameAndUserIp("titaniume2", "192.168.0.1");
		System.out.println(result);
	}

	//2,使用自定义语句查询 这个优先级比select2的高
	@Test
	public void select4() {
		List<UserLog> result = userLogDao.findByUserIp("127.0.0.1");
		System.out.println(result);
	}
	
	
	//分页  0 开始页  20:每页多少条数据
	
	@Test
	public void queryForPage() {
		Pageable pageable = new PageRequest(0, 20, new Sort(new
		Order(Direction.DESC, "id")));
		Page<UserLog> result =userLogDao.findByUserName("titaniume2", pageable);
		System.out.println(result.getContent());
	}
	

}
