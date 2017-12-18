package cn.gov.service;

import cn.gov.entity.Admin;
import cn.gov.entity.User;

public interface AdminService {
	public Admin login(Admin admin);
	public boolean addAdmin(Admin admin);
	public int updateAdmin(Admin admin);
	public void updatePassword(Admin admin);
}
