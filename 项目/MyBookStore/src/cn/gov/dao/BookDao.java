package cn.gov.dao;

import java.util.List;

import cn.gov.entity.Book;

public interface BookDao {
	
	//得到所有的书籍
	public List<Book> getBooks();
	
	public Book getBook(Integer id);
	
	//删除书籍
        public void deleteBook(Integer id);

}
