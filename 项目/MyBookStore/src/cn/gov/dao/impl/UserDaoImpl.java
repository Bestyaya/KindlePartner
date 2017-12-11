package cn.gov.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.gov.dao.HibernateSessionFactory;
import cn.gov.dao.UserDao;
import cn.gov.entity.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	public User getUser(User user) {
		// TODO Auto-generated method stub
		
		String hql =  String.format("from User where username = '%s' and password " +
				"= '%s'",user.getUsername(),user.getPassword());
		Session session = HibernateSessionFactory.getSession();
		Query q = session.createQuery(hql);
		
		return (User)q.uniqueResult();
	}

	public String addUser(User item) {
		System.out.println(item.getUsername());
		getHibernateTemplate().save(item);
		return item.getUsername();
	}
	
}
