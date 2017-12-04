package cn.gov.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.gov.entity.Book;
import cn.gov.entity.User;
import cn.gov.service.UserService;
import cn.gov.util.JsonResult;

public class BookAction {

	private Book book;
	private String json;
	private UserService userService;
	private JsonResult jsonResult;

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
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

	public List<Book> getBooks()
	{
		List<Book> books = new ArrayList<Book>();
		
		return books;
	}
}
