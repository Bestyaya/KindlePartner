package cn.gov.action;

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
	
	public String login()
	{
		System.out.println(1111111111);
		System.out.println(user.getUsername());
		
		boolean ok = userService.login(user); //ÅÐ¶ÏÊÇ·ñµÇÂ¼³É¹¦
		if(ok)
		{
			jsonResult.setSuccess(true);
			jsonResult.setMessage("µÇÂ¼³É¹¦!");
		}
		else
		{
			jsonResult.setSuccess(false);
			jsonResult.setMessage("µÇÂ¼Ê§°Ü");
		}
		
		return "jsonResult";
	}

}
