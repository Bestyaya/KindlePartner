package cn.gov.service.impl;

import cn.gov.dao.AdminDao;
import cn.gov.entity.Admin;
import cn.gov.entity.User;
import cn.gov.service.AdminService;

public class AdminServiceImpl implements AdminService {
	
	private AdminDao adminDao;

	public AdminDao getAdminDao() {
		return adminDao;
	}

	public void setAdminDao(AdminDao admindao) {
		this.adminDao = adminDao;
	}
	
	public Admin login(Admin admin) {
		// TODO Auto-generated method stub

		return adminDao.getAdmin(admin);
	}

	public int updateAdmin(Admin admin)
	{
	        return adminDao.updateAdmin(admin);
	}
	
	public boolean addAdmin(Admin admin) {
		if (adminDao.addAdmin(admin) > 0)
			return true;
		return false;
	}

	public void updatePassword(Admin admin)
	{
	        adminDao.updatePassword(admin);
	}

}
