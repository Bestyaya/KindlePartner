package cn.gov.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.gov.entity.Book;
import cn.gov.entity.Cart;
import cn.gov.entity.User;
import cn.gov.service.BookService;
import cn.gov.service.CartService;
import cn.gov.service.UserService;
import cn.gov.util.JsonResult;

public class CartAction {

        private Cart cart;
        private BookService bookService;
        private String json;
        private CartService cartService;
        private JsonResult jsonResult;
        private Integer delete_id;
        
        public Integer getDelete_id() {
                return delete_id;
        }

        public void setDelete_id(Integer delete_id) {
                this.delete_id = delete_id;
        }
        
        public Cart getCart() {
                return cart;
        }

        public void setCart(Cart cart) {
                this.cart = cart;
        }

        public BookService getBookService() {
                return bookService;
        }

        public void setBookService(BookService bookService) {
                this.bookService = bookService;
        }
        
        public String getJson() {
                return json;
        }

        public void setJson(String json) {
                this.json = json;
        }

        public CartService getCartService() {
                return cartService;
        }

        public void setCartService(CartService cartService) {
                this.cartService = cartService;
        }

        public JsonResult getJsonResult() {
                return jsonResult;
        }

        public void setJsonResult(JsonResult jsonResult) {
                this.jsonResult = jsonResult;
        }

        //显示图书
        public String show()
        {
                HttpServletRequest request = ServletActionContext.getRequest();
                HttpSession session = request.getSession();

                User user = (User) session.getAttribute("user");
                if(user == null) return "noLogin";
                List<Cart> cartes = cartService.getAllCart(user);
                session.setAttribute("cartes",cartes); 
                return "cartes";
        }
        
        //加入购物车
        public String submit() {

                jsonResult = new JsonResult();
         
                HttpServletRequest request = ServletActionContext.getRequest();
                HttpSession session = request.getSession();

                User user = (User) session.getAttribute("user");
                Book book = (Book) session.getAttribute("booktoadd");

                if (user == null) {
                        jsonResult.setSuccess(false);
                        jsonResult.setMessage("检测到您还未登录，请先登录");
                        return "noLogin";
                }
                
                boolean ok;
                Cart cart = cartService.getCart(user.getId(), book.getId());
                if(cart == null)
                {
                        cart = new Cart();
                        cart.setNumber(1);
                        cart.setUser_id(user.getId());
                        cart.setBook_id(book.getId());
                        cart.setState(0);
                        ok = cartService.saveCart(cart);
                }       
                else
                {
                        if(cartService.updateCart(cart.getId(),cart.getNumber() + 1) > 0)
                                ok = true;
                        else
                                ok = false;
                }
                
                if (ok) {
                        jsonResult.setSuccess(true);
                        jsonResult.setMessage("成功加入购物车");
                } else {
                        jsonResult.setSuccess(false);
                        jsonResult.setMessage("提交失败");
                }
                return "jsonResult";
        }
        
        //清空购物车
        public String deleteAll()
        {
                HttpServletRequest request = ServletActionContext.getRequest();
                HttpSession session = request.getSession();
                
               List<Cart> cartes = (List<Cart>)session.getAttribute("cartes");
               for(Cart cart : cartes)
                       cartService.deleteCart(cart.getId());
                
                show();
                
                return "f5";
        }
        
        //清空购物车
        public String deleteCart()
        {
                if(delete_id != null) System.out.println(delete_id);
                else System.out.println("null");
                cartService.deleteCart(delete_id);
                
                show();
                
                return "f5";
        }
        
        //购买历史
        public String history()
        {
                HttpServletRequest request = ServletActionContext.getRequest();
                HttpSession session = request.getSession();

                User user = (User) session.getAttribute("user");
                List<Cart> history = cartService.getHistory(user);
                session.setAttribute("history",history); 
                System.out.println(history.size());
                return "history";
        }

}
