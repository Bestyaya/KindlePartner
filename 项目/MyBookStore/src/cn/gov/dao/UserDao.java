package cn.gov.dao;

import java.util.List;

import cn.gov.entity.User;

public interface UserDao {
	
	//得到用户名得到相关用户
	public User getUser(User user);
	
	//添加用户
	public Integer addUser(User item);
	
	//修改用户
	public int updateUser(User user);
	
	//修改密码
	public void updatePassword(User user);
	
	//得到所有的用户
	public List<User> getAllUser();

	public void kickAndUnkick(User user);
	
	public User getUserById(Integer id);
	
}
