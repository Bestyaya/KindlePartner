package cn.gov.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.gov.entity.Book;
import cn.gov.entity.User;
import cn.gov.service.BookService;
import cn.gov.service.UserService;
import cn.gov.util.JsonResult;

public class BookAction {

	private Book book;
	private String json;
	private BookService bookService;
	private JsonResult jsonResult;

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
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

	public JsonResult getJsonResult() {
		return jsonResult;
	}

	public void setJsonResult(JsonResult jsonResult) {
		this.jsonResult = jsonResult;
	}

	public String error() {
		return "error";
	}

	//获得所有图书
	public String getBooks()
	{
		List<Book> books = bookService.getAllBook();
		HttpServletRequest request = ServletActionContext.getRequest();
                HttpSession session = request.getSession();
                session.setAttribute("books", books);
		return "success";
	}
}
