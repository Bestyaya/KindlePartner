package cn.gov.service.impl;

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

	public boolean login(User user) {
		// TODO Auto-generated method stub

		if (userDao.getUser(user) != null)
			return true;

		return false;
	}

	public boolean addUser(User user) {
		if (userDao.addUser(user) != null)
			return true;
		return false;
	}

}
