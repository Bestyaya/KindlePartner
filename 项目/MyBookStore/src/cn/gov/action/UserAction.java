package cn.gov.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.gov.entity.Cart;
import cn.gov.entity.User;
import cn.gov.service.CartService;
import cn.gov.service.UserService;
import cn.gov.util.JsonData;
import cn.gov.util.JsonResult;

public class UserAction {

        private User user;
        private String json;
        private CartService cartService; 
        private UserService userService;
        private JsonResult jsonResult;
        private JsonData jsonData;

        public JsonData getJsonData() {
                return jsonData;
        }

        public void setJsonData(JsonData jsonData) {
                this.jsonData = jsonData;
        }

        public UserService getUserService() {
                return userService;
        }

        public void setUserService(UserService userService) {
                this.userService = userService;
        }
        
        public CartService getCartService() {
                return cartService;
        }

        public void setCartService(CartService cartService) {
                this.cartService = cartService;
        }

        public User getUser() {
                return user;
        }

        public void setUser(User user) {
                this.user = user;
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

        //出错
        public String error() {
                return "error";
        }
        
        public String bug()
        {
                HttpServletRequest request = ServletActionContext.getRequest();
                HttpSession session = request.getSession();
                
                User user= (User)session.getAttribute("user");
                Double money = (Double)session.getAttribute("totalMoney");
                List<Cart> cartes = (List<Cart>)session.getAttribute("cartes");
                
                user.setBalance(user.getBalance() - money);
                userService.updateUser(user);
                
                for(Cart cart : cartes)
                {
                        cart.setState(1);
                        cartService.updateCart(cart);
                }
                
                return "success";
        }

        //登录
        public String login() {

                jsonResult = new JsonResult(); // 实例化JsonResult

                user = userService.login(user); // 判断是否登录成功
                if (user != null) {
                        HttpServletRequest request = ServletActionContext
                                        .getRequest();
                        HttpSession session = request.getSession();
                        session.setAttribute("user", user);
                        jsonResult.setSuccess(true);
                        jsonResult.setMessage("登录成功！");
                        return "success";

                } else {
                        jsonResult.setSuccess(false);
                        jsonResult.setMessage("用户名或密码不匹配，登录失败！");
                }

                return "jsonResult";
        }

        //注册
        public String register() {

                jsonResult = new JsonResult(); // 实例化JsonResult

                boolean ok = userService.addUser(user); // 判断是否添加成功
                if (ok) {
                        jsonResult.setSuccess(true);
                        jsonResult.setMessage("登录成功！");
                } else {
                        jsonResult.setSuccess(false);
                        jsonResult.setMessage("用户名或密码不匹配，登录失败！");
                }

                return "login";
        }

}
