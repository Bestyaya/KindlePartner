package cn.gov.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.gov.entity.Book;
import cn.gov.entity.Cart;
import cn.gov.entity.User;
import cn.gov.service.CartService;
import cn.gov.service.UserService;
import cn.gov.util.JsonResult;

public class CartAction {

        private Cart cart;
        private String json;
        private CartService cartService;
        private JsonResult jsonResult;

        public Cart getCart() {
                return cart;
        }

        public void setCart(Cart cart) {
                this.cart = cart;
        }

        public CartService getCartService() {
                return cartService;
        }

        public void setCartService(CartService cartService) {
                this.cartService = cartService;
        }
        
        public String getJson() {
                return json;
        }

        public void setJson(String json) {
                this.json = json;
        }

        public JsonResult getJsonResult() {
                return jsonResult;
        }

        public void setJsonResult(JsonResult jsonResult) {
                this.jsonResult = jsonResult;
        }

        public String error() {
                return "error";
        }

        public String submit()
        {
                HttpServletRequest request = ServletActionContext.getRequest();
                HttpSession session = request.getSession();
                User user = (User)session.getAttribute("user");
                Book book = (Book)session.getAttribute("booktoadd");
                Cart cart = new Cart();
                cart.setUser(user);
                cart.setBook(book);
                cart.setState(0);
                boolean ok = cartService.saveCart(cart);
                jsonResult = new JsonResult();
                if(ok)
                {
                        System.out.println(1);
                        jsonResult.setSuccess(true);
                        jsonResult.setMessage("成功加入购物车");
                }
                else
                {
                        System.out.println(2);
                        jsonResult.setSuccess(false);
                        jsonResult.setMessage("提交失败");
                }
                return "jsonResult";
        }
        
}
