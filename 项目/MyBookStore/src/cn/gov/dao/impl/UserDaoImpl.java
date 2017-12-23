package cn.gov.dao.impl;

import java.util.List;

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

	//添加用户
	public Integer addUser(User item) {

		item.setState(1);
		item.setVip(0);   //初始化VIP等级
		item.setBalance(10000.00);  //初始余额
		getHibernateTemplate().save(item);
		return item.getId();
	}
	
	public int updateUser(User user)
	{
	        getHibernateTemplate().update(user);
                return user.getId();
	}
	
	public void updatePassword(User user)
	{
	        getHibernateTemplate().update(user);
	}
	
	public List<User> getAllUser()
	{
	        String hql = "from User";
                Query q = getSession().createQuery(hql);
                return q.list();
	}
	
	//根据id得到user
	public User getUserById(Integer id)
	{
	        String hql = String.format("from User as user where id == "+id);
	        Session session = HibernateSessionFactory.getSession();
                Query q = session.createQuery(hql);
                
                return (User)q.uniqueResult();
	}
	
	// !user.state
	public void kickAndUnkick(User user)
	{
	        if(user.getId() == 1) user.setId(0);
	        else user.setId(1);
	        getHibernateTemplate().update(user);
	}
	
}
