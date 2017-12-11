package com.titaniume.springboot.component;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

/**
 * 处理readis key-value
 * @author titaniume
 * 2017年12月9日下午11:03:15
 *
 */
@Component
public class TitaniumeRedisComponent {
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	
	public void set(String key,String value){
		 ValueOperations<String, String> ops = this.stringRedisTemplate.opsForValue();
		 if(!this.stringRedisTemplate.hasKey(key)){
			 ops.set(key, value);
			 System.out.println("set key success");
		 }else{
			 //存在的key则打印值
			 System.out.println("this key ="+ops.get(key));
		 }
	}
	

	public String get(String key){
		return this.stringRedisTemplate.opsForValue().get(key);
	}
	
	
	public void delete(String key){
		 this.stringRedisTemplate.delete(key);
	}
}
