package cn.gov.entity;

/**
 * Cart entity. @author MyEclipse Persistence Tools
 */

public class Cart implements java.io.Serializable {

        // Fields

        private Integer id;
        private User user;
        private Book book;
        private Integer state;

        // Constructors

        /** default constructor */
        public Cart() {
        }

        /** minimal constructor */
        public Cart(Integer state) {
                this.state = state;
        }

        /** full constructor */
        public Cart(User user, Book book, Integer state) {
                this.user = user;
                this.book = book;
                this.state = state;
        }

        // Property accessors

        public Integer getId() {
                return this.id;
        }

        public void setId(Integer id) {
                this.id = id;
        }

        public User getUser() {
                return this.user;
        }

        public void setUser(User user) {
                this.user = user;
        }

        public Book getBook() {
                return this.book;
        }

        public void setBook(Book book) {
                this.book = book;
        }

        public Integer getState() {
                return this.state;
        }

        public void setState(Integer state) {
                this.state = state;
        }

}