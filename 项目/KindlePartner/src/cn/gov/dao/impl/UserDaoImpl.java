package cn.gov.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;

import cn.gov.dao.HibernateSessionFactory;
import cn.gov.dao.UserDao;
import cn.gov.entity.User;

public class UserDaoImpl implements UserDao {

	public User getUser(User user) {
		// TODO Auto-generated method stub
		
		String hql =  String.format("from User where loginid = '%s'",user.getUsername());
		Session session = HibernateSessionFactory.getSession();
		Query q = session.createQuery(hql);
		
		return (User) q.uniqueResult();
	}

}
