package cn.gov.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.gov.dao.CartDao;
import cn.gov.dao.HibernateSessionFactory;
import cn.gov.entity.Cart;
import cn.gov.entity.User;

public class CartDaoImpl extends HibernateDaoSupport implements CartDao {

        
        public int saveCart(Cart cart)
        {
                getHibernateTemplate().save(cart);
                return cart.getId();
        }
        
        public List<Cart> getAllCart(User user)
        {
                String hql = String.format("from Cart as cart where cart.user_id= "+user.getId()+"and cart.state = 0");
                Query q = getSession().createQuery(hql);
                return q.list();
        }
        
        public Cart getCart(Integer user_id, Integer book_id)
        {
                String hql = String.format("from Cart as cart where cart.user_id = "+user_id+"and cart.book_id = "+book_id);
                Session session = HibernateSessionFactory.getSession();
                Query q = session.createQuery(hql);
                
                return (Cart)q.uniqueResult();
        }
        
        public int updateCart(Integer id, Integer number)
        {
                String hql = String.format("update Cart set number = '%s' where id='%s' ",number,id);
                Query q = getSession().createQuery(hql);
                return q.executeUpdate();
        }
        
        public int updateCart(Cart cart)
        {
                getHibernateTemplate().update(cart);
                return cart.getId();
        }
        
}
