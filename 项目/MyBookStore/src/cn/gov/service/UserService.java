package cn.gov.service;

import cn.gov.entity.User;

public interface UserService {
	
	public User login(User user);
	public boolean addUser(User user);
	public int updateUser(User user);
	public void updatePassword(User user);

}
