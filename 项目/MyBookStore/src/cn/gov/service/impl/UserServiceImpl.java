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

	public User login(User user) {
		// TODO Auto-generated method stub

		return userDao.getUser(user);
	}

	public int updateUser(User user)
	{
	        return userDao.updateUser(user);
	}
	
	public boolean addUser(User user) {
		if (userDao.addUser(user) > 0)
			return true;
		return false;
	}

	public void updatePassword(User user)
	{
	        userDao.updatePassword(user);
	}
	
	//得到所有的用户
	public List<User> getAllUser()
	{
	        return userDao.getAllUser();
	}
	
	public User getUserById(Integer id)
	{
	        return userDao.getUserById(id);
	}
	
	public void kickAndUnkick(User user)
	{
	        userDao.kickAndUnkick(user);
	}
}
