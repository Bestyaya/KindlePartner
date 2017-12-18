package cn.gov.dao;

import cn.gov.entity.Admin;
import cn.gov.entity.User;

public interface AdminDao {

	//得到用户名得到相关用户
	public Admin getAdmin(Admin admin);
	
	//添加用户
	public Integer addAdmin(Admin admin);
	
	//修改用户
	public int updateAdmin(Admin admin);
	
	//修改密码
	public void updatePassword(Admin admin);
	
}
