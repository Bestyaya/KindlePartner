package cn.gov.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.gov.dao.BookDao;
import cn.gov.entity.Book;

public class BookDaoImpl extends HibernateDaoSupport implements BookDao {

	public List<Book> getBooks() {
		// TODO Auto-generated method stub
		String hql = "from Book";
		Query q = getSession().createQuery(hql);
		return q.list();
	}

}
