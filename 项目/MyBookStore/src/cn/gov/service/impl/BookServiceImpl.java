package cn.gov.service.impl;

import java.util.List;

import cn.gov.dao.BookDao;
import cn.gov.entity.Book;
import cn.gov.service.BookService;

public class BookServiceImpl implements BookService {

	private BookDao bookDao;
	
	public BookDao getBookDao() {
		return bookDao;
	}

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	public List<Book> getAllBook() {
		// TODO Auto-generated method stub
	        System.out.println("I'M HERE");
	        if(bookDao == null) System.out.println("NULL");
	        else System.out.println("NOT NULL");
		List<Book> books = bookDao.getBooks();
		
		return books;
	}

}
