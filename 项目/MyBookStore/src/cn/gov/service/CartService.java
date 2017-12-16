package cn.gov.service;

import java.util.List;

import cn.gov.entity.Cart;
import cn.gov.entity.User;

public interface CartService {

        public boolean saveCart(Cart cart);
        public List<Cart> getAllCart(User user);
        public Cart getCart(Integer user_id, Integer book_id);
        public int updateCart(Integer id,  Integer number);
        public int updateCart(Cart cart);
}
