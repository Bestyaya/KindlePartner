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
        
        private String oldpassword;
        private String newpassword;
        private String newpassword2;
        
        public String getOldpassword() {
                return oldpassword;
        }

        public void setOldpassword(String oldpassword) {
                this.oldpassword = oldpassword;
        }

        public String getNewpassword() {
                return newpassword;
        }

        public void setNewpassword(String newpassword) {
                this.newpassword = newpassword;
        }

        public String getNewpassword2() {
                return newpassword2;
        }

        public void setNewpassword2(String newpassword2) {
                this.newpassword2 = newpassword2;
        }

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
        
        //退出
        public String logout()
        {
                HttpServletRequest request = ServletActionContext.getRequest();
                HttpSession session = request.getSession();
                session.setAttribute("user",null);
                return "login";
        }
        
        //更新信息
        public String updateInformation()
        {
                HttpServletRequest request = ServletActionContext.getRequest();
                HttpSession session = request.getSession();
                
                User user= (User)session.getAttribute("user");
                if(!user.getPassword().equals(oldpassword))
                      return   "fail";
                if(!newpassword.equals(newpassword2))
                        return "fail";
                
                user.setPassword(newpassword);
                
                userService.updatePassword(user);
                
                return "user";
        }
        
        //购买功能
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
                        if(user.getId() == 1)
                        {
                                jsonResult.setSuccess(false);
                                jsonResult.setMessage("登录失败，您已被封号！");
                                return "jsonResult";
                        }
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
