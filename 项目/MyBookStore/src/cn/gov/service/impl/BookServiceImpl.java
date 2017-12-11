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
		return bookDao.getBooks();
	}

}
