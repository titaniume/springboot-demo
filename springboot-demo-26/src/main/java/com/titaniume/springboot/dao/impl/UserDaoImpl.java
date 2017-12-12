package com.titaniume.springboot.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.titaniume.springboot.bean.User;
import com.titaniume.springboot.dao.UserDao;

@Repository
public class UserDaoImpl  implements UserDao {

	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	@Override
	public int insert(User user) {
		String sql = "insert into user(name,create_time) values(?,?)";
		return jdbcTemplate.update(sql, user.getName(), user.getCreateTime());
	}

	@Override
	public int deleteById(int id) {
		String sql ="delete from user where id=?";
		return jdbcTemplate.update(sql,id);
	}

	@Override
	public int updateById(User user) {
		String sql ="update user set name=?,create_time=? where id=?";
		return jdbcTemplate.update(sql,user.getName(),user.getCreateTime(),user.getId());
	}

	@Override
	public User selectById(int id) {
		String sql ="select * from user where id=?";
		return jdbcTemplate.queryForObject(sql, new RowMapper<User>(){

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setCreateTime(rs.getDate("create_time"));
				return user;
			}
			
		}, id);
		
	}

	
}
