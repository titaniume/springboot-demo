package com.titaniume.springboot.cache;

import com.titaniume.springboot.bean.UserLog;

public interface TitaniumeUserLogCache {
	/**
	 * 查询
	 *
	 * @param id
	 * @return
	 */
	UserLog selectById(Integer id);

	/**
	 * 更新
	 *
	 * @param UserLog
	 * @return
	 */
	UserLog updateById(UserLog UserLog);

	/**
	 * 删除
	 *
	 * @param id
	 * @return
	 */
	String deleteById(Integer id);
}