package cn.gov.dao;

import java.util.List;

import cn.gov.entity.Cart;
import cn.gov.entity.User;

public interface CartDao {

        public int saveCart(Cart cart);
        
        public List<Cart> getAllCart(User user);
        public Cart getCart(Integer user_id, Integer book_id);
        public int updateCart(Integer id,Integer number);
}
