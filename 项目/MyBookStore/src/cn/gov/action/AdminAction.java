package cn.gov.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.gov.entity.Admin;
import cn.gov.service.AdminService;
import cn.gov.util.JsonResult;

public class AdminAction {

	private Admin admin;
	private JsonResult jsonResult;
	private AdminService adminService;

	public JsonResult getJsonResult() {
		return jsonResult;
	}

	public void setJsonResult(JsonResult jsonResult) {
		this.jsonResult = jsonResult;
	}

	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	// 跳转到管理员登录
	public String login() {
		return "login";
	}

	// 管理员登录功能
	public String Login() {
		System.out.println(1);
		jsonResult = new JsonResult();
		admin = adminService.login(admin); // 判断是否登录成功
		if (admin != null) {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			session.setAttribute("admin", admin);
			jsonResult.setSuccess(true);
			jsonResult.setMessage("登录成功！");
			return "success";

		} else {
			jsonResult.setSuccess(false);
			jsonResult.setMessage("用户名或密码不匹配，登录失败！");
		}

		return "jsonResult";
	}

}
