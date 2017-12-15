package cn.gov.service.impl;

import cn.gov.dao.CartDao;
import cn.gov.entity.Cart;
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
        
}
