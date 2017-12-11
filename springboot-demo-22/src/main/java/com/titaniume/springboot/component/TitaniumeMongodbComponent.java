package com.titaniume.springboot.component;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.titaniume.springboot.bean.User;

@Component
public class TitaniumeMongodbComponent {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	
	public void insert(User user){
		mongoTemplate.insert(user);
	}
	
	public void deleteById(int id){
		Criteria criteria = Criteria.where("id").in(id);
		Query query = new Query(criteria);
		mongoTemplate.remove(query,User.class);
	}
	
	public void updateById(User user){
		Criteria criteria = Criteria.where("id").in(user.getId());
		Query query = new Query(criteria);
		Update update = new Update();
		update.set("name", user.getName());
		update.set("createTime", user.getCreateTime());
		mongoTemplate.updateMulti(query, update, User.class);	
	}
	
	public User selectById(int id){
		Criteria criteria = Criteria.where("id").in(id);
		Query query = new Query(criteria);
		return mongoTemplate.findOne(query, User.class);
	}
}
