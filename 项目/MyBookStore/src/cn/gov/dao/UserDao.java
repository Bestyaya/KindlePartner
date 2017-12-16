package cn.gov.dao;

import cn.gov.entity.User;

public interface UserDao {
	
	//得到用户名得到相关用户
	public User getUser(User user);
	
	//添加用户
	public Integer addUser(User item);
	
	//修改用户
	public int updateUser(User user);

}
