package cn.gov.service.impl;

import java.util.List;

import cn.gov.dao.UserDao;
import cn.gov.entity.User;
import cn.gov.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	//登录
	public User login(User user) {
		// TODO Auto-generated method stub

		return userDao.getUser(user);
	}

	//更改密码
	public int updateUser(User user)
	{
	        return userDao.updateUser(user);
	}
	
	//添加用户
	public boolean addUser(User user) {
		if (userDao.addUser(user) > 0)
			return true;
		return false;
	}

	//更改密码
	public void updatePassword(User user)
	{
	        userDao.updatePassword(user);
	}
	
	//得到所有的用户
	public List<User> getAllUser()
	{
	        return userDao.getAllUser();
	}
	
	//根据主键得到用户
	public User getUserById(Integer id)
	{
	        return userDao.getUserById(id);
	}
	
	//封号和解封号
	public void kickAndUnkick(User user)
	{
	        userDao.kickAndUnkick(user);
	}
}
