package cn.gov.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.gov.entity.User;
import cn.gov.service.UserService;
import cn.gov.util.JsonResult;


public class UserAction {
	
    private User user;
    private String json;
    private UserService userService;
    private JsonResult jsonResult;
    
    public UserService getUserService() {
		return userService;
	}
    public void setUserService(UserService userService) {
		this.userService = userService;
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
	
	public String error()
	{
		return "error";
	}
	
	public String login()
	{
		
		jsonResult = new JsonResult();  //实例化JsonResult
		
		boolean ok = userService.login(user); //判断是否登录成功
		if(ok)
		{
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			jsonResult.setSuccess(true);
			jsonResult.setMessage("登录成功！");
			
			return "success";
		}
		else
		{
			jsonResult.setSuccess(false);
			jsonResult.setMessage("用户名或密码不匹配，登录失败！");
		}
		
		return "login";
	}
	
	
	public String register()
	{
		
		jsonResult = new JsonResult();  //实例化JsonResult
		
		boolean ok = userService.login(user); //判断是否登录成功
		if(ok)
		{
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			jsonResult.setSuccess(true);
			jsonResult.setMessage("登录成功！");
		}
		else
		{
			jsonResult.setSuccess(false);
			jsonResult.setMessage("用户名或密码不匹配，登录失败！");
		}
		
		return "success";
	}
	

}
