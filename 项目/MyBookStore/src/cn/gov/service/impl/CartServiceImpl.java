package cn.gov.service.impl;

import java.util.List;

import cn.gov.dao.CartDao;
import cn.gov.entity.Cart;
import cn.gov.entity.User;
import cn.gov.service.CartService;

public class CartServiceImpl implements CartService {

        private CartDao cartDao;
        
        public CartDao getCartDao() {
                return cartDao;
        }

        public void setCartDao(CartDao cartDao) {
                this.cartDao = cartDao;
        }
        
        public boolean saveCart(Cart cart)
        {
                if(cartDao.saveCart(cart) > 0)
                        return true;
                return false;
        }
        
        public List<Cart> getAllCart(User user)
        {
                return cartDao.getAllCart(user);
        }
        
        public Cart getCart(Integer user_id, Integer book_id)
        {
                return cartDao.getCart(user_id, book_id);
        }
        
        public int updateCart(Integer id,Integer number)
        {
                return cartDao.updateCart(id,number);
        }
        
        public int updateCart(Cart cart)
        {
                return cartDao.updateCart(cart);
        }
        
        public List<Cart> getHistory(User user)
        {
                return cartDao.getHistory(user);
        }
        
        public void deleteCart(Integer id)
        {
                cartDao.deleteCart(id);
        }
        
}
