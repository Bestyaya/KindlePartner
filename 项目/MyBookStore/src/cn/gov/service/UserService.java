package cn.gov.service;

import java.util.List;

import cn.gov.entity.User;

public interface UserService {
	
	public User login(User user);
	public boolean addUser(User user);
	public int updateUser(User user);
	public void updatePassword(User user);
	public List<User> getAllUser();
	public User getUserById(Integer id);
	public void kickAndUnkick(User user);

}
