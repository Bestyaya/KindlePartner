package cn.gov.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.gov.dao.AdminDao;
import cn.gov.dao.HibernateSessionFactory;
import cn.gov.entity.Admin;
import cn.gov.entity.User;

public class AdminDaoImpl extends HibernateDaoSupport implements AdminDao {

	public Admin getAdmin(Admin admin) {
		// TODO Auto-generated method stub
		
		String hql =  String.format("from Admin where name = '%s' and password " +
				"= '%s'",admin.getName(),admin.getPassword());
		Session session = HibernateSessionFactory.getSession();
		Query q = session.createQuery(hql);
		return (Admin)q.uniqueResult();
	}

	//添加用户
	public Integer addAdmin(Admin item) {

		getHibernateTemplate().save(item);
		return item.getId();
	}
	
	public int updateAdmin(Admin admin)
	{
	        getHibernateTemplate().update(admin);
                return admin.getId();
	}
	
	public void updatePassword(Admin admin)
	{
	        getHibernateTemplate().update(admin);
	}

}
