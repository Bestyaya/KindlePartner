package cn.gov.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.gov.dao.CartDao;
import cn.gov.entity.Cart;

public class CartDaoImpl extends HibernateDaoSupport implements CartDao {

        
        public int saveCart(Cart cart)
        {
                getHibernateTemplate().save(cart);
                System.out.println("safdsghkl;lkhjgfd");
                return cart.getId();
        }
        
}
