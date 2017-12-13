package com.titaniume.springboot.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import com.titaniume.springboot.bean.User;

@Mapper
public interface UserMapper {
	
	@Insert(value = "insert into user (name, create_time) values (#{name,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP})")
	int insert(User user);

	@Select(value = "select id, name, create_time from user where id = #{id,jdbcType=INTEGER}")
	@Results(value = { @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP) })
	User selectByPrimaryKey(Integer id);
}
