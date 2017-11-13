package cn.gov.dao;

import cn.gov.entity.User;

public interface UserDao {
	
	//根据用户名获取用户信息
	public User getUser(User user);

}
