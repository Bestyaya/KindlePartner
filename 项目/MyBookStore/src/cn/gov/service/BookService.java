package cn.gov.service;

import java.util.List;

import cn.gov.entity.Book;

public interface BookService {

	//得到所有的书籍
	public List<Book> getAllBook();
	
	public Book getBook(Integer id);
	
}
