package cn.gov.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.gov.dao.BookDao;
import cn.gov.entity.Book;
import cn.gov.entity.Cart;
import cn.gov.entity.User;

public class BookDaoImpl extends HibernateDaoSupport implements BookDao {

        //得到所有的书籍
	public List<Book> getBooks() {
		// TODO Auto-generated method stub
		String hql = "from Book";
		Query q = getSession().createQuery(hql);
		return q.list();
	}

	//根据id得到书籍
	public Book getBook(Integer id)
	{
	        String hql = String.format("from Book as book where id =="+id);
                Query q = getSession().createQuery(hql);
                return (Book)q.uniqueResult();
	}
	
	//根据删除书籍
        public void deleteBook(Integer id)
        {
                getHibernateTemplate().delete(new Book(id));
        }
	
}
