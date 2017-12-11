package com.titaniume.springboot;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.titaniume.springboot.bean.User;
import com.titaniume.springboot.component.TitaniumeMongodbComponent;

/**
 * 测试MongoDB
 * 
 * @author titaniume 
 * 2017年12月10日下午12:13:53
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootDemo21ApplicationTests_1 {

	@Autowired
	private TitaniumeMongodbComponent titaniumeMongodbComponent;
	//注意:mongodb 不支持自增，所以插入不能插入同一个id不然会报下面的错误
	//DEBUG [main] org.springframework.data.mongodb.core.MongoTemplate [1046] -| Inserting DBObject containing fields: [_class, _id, name, createTime] in collection: user
	@Test
	public void set() {
		User User = new User();
		User.setId(3);
		User.setName("6666");
		User.setCreateTime(new Date());
		titaniumeMongodbComponent.insert(User);
	}

	@Test
	public void select() {
		System.out.println(titaniumeMongodbComponent.selectById(3));
	}

	@Test
	public void update() {
		User User = new User();
		User.setId(3);
		User.setName("测试修改");
		User.setCreateTime(new Date());
		titaniumeMongodbComponent.updateById(User);
		System.out.println(titaniumeMongodbComponent.selectById(2));
	}

	@Test
	public void delete() {
		titaniumeMongodbComponent.deleteById(1);
	}
}
