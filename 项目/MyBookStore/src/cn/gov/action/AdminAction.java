package cn.gov.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.gov.entity.Admin;
import cn.gov.entity.Book;
import cn.gov.entity.User;
import cn.gov.service.AdminService;
import cn.gov.service.BookService;
import cn.gov.service.UserService;
import cn.gov.util.JsonResult;

public class AdminAction {

        private User user;
	private Admin admin;
	private JsonResult jsonResult;
	private AdminService adminService;
	private BookService bookService;
        private UserService userService;
        private Integer delete_id;
        private Integer id;
        
        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
        }

        public Integer getDelete_id() {
                return delete_id;
        }

        public void setDelete_id(Integer delete_id) {
                this.delete_id = delete_id;
        }
        
        public User getUser() {
                return user;
        }

        public void setUser(User user) {
                this.user = user;
        }

        public BookService getBookService() {
                return bookService;
        }

        public void setBookService(BookService bookService) {
                this.bookService = bookService;
        }

        public UserService getUserService() {
                return userService;
        }

        public void setUserService(UserService userService) {
                this.userService = userService;
        }


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

	// 跳转到管理员登录页面
	public String login() {
		return "login";
	}

	// 管理员登录功能
	public String Login() {
		
	        jsonResult = new JsonResult();
		
		admin = adminService.login(admin); // 根据账户密码获取对象
		
		if (admin != null) {    //如果没有该对象
		        
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			
			//将管理员信息存储到会话里同时将user置为null
			session.setAttribute("admin", admin);
			session.setAttribute("user",null);
			
			jsonResult.setSuccess(true);    //设置返回的json数据
			jsonResult.setMessage("登录成功！");

		} else {
			jsonResult.setSuccess(false);
			jsonResult.setMessage("账号或密码不匹配，登录失败！");
		}

		return "jsonResult";
	}
	
	// 退出功能
        public String logout() {
                
                HttpServletRequest request = ServletActionContext.getRequest();
                HttpSession session = request.getSession();
                
                session.setAttribute("admin",null);  //将管理员从会话中移出

                return "index";
        }
        
        //显示书籍管理界面
        public String bookManager()
        {
                HttpServletRequest request = ServletActionContext.getRequest();
                HttpSession session = request.getSession();
                
                List<Book> books = bookService.getAllBook();                 
                
                session.setAttribute("books", books);
                
                return "book";
        }
        
        //显示用户管理界面
        public String userManager()
        {
                HttpServletRequest request = ServletActionContext.getRequest();
                HttpSession session = request.getSession();
                
                List<User> users = userService.getAllUser();   
                
                session.setAttribute("users", users);
                
                return "user";
        }
        
        //下架图书
        public String deleteBook()
        {
                
                bookService.deleteBook(delete_id);  //根据id删除图书
                
                return bookManager();  //刷新
        }
        
        //封号和解封号
        public String kickAndUnkick()
        {
                if(id != null) System.out.println(id);
                else System.out.println("null");
                User u = userService.getUserById(id);  //得到user
                userService.kickAndUnkick(u);  //解封号
                return userManager();
        }

}
