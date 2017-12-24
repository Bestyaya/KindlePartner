package cn.gov.service.impl;

import java.util.List;

import cn.gov.dao.BookDao;
import cn.gov.entity.Book;
import cn.gov.service.BookService;
import cn.gov.util.*;

public class BookServiceImpl implements BookService {
        
        private BookDao bookDao;

        public BookDao getBookDao() {
                return bookDao;
        }

        public void setBookDao(BookDao bookDao) {
                this.bookDao = bookDao;
        }
        
      //得到所有的书籍
        public List<Book> getAllBook()
        {
                return bookDao.getBooks(); 
        }

        //根据id得到特定的书籍
        public Book getBook(Integer id)
        {
                return bookDao.getBook(id);
        }
        
        //删除书籍
        public void deleteBook(Integer id)
        {
                bookDao.deleteBook(id);
        }

}
