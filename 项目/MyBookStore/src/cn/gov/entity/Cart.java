package cn.gov.entity;

/**
 * Cart entity. @author MyEclipse Persistence Tools
 */

public class Cart implements java.io.Serializable {

        // Fields

        private Integer id;
        private Integer book_id;
        private Integer user_id;
        private Integer state;
        private Integer number;

        // Constructors

        /** default constructor */
        public Cart() {
        }
        
        public Cart(Integer book_id, Integer user_id, Integer state) {
                super();
                this.book_id = book_id;
                this.user_id = user_id;
                this.state = state;
        }
        
        public Cart(Integer state) {
                this.state = state;
        }
        
        public Cart(Integer id, Integer book_id, Integer user_id, Integer state) {
                super();
                this.id = id;
                this.book_id = book_id;
                this.user_id = user_id;
                this.state = state;
        }
        
        public Integer getNumber() {
                return number;
        }

        public void setNumber(Integer number) {
                this.number = number;
        }


        public Integer getBook_id() {
                return book_id;
        }

        public void setBook_id(Integer book_id) {
                this.book_id = book_id;
        }

        public Integer getUser_id() {
                return user_id;
        }


        public void setUser_id(Integer user_id) {
                this.user_id = user_id;
        }

        // Property accessors

        public Integer getId() {
                return this.id;
        }

        public void setId(Integer id) {
                this.id = id;
        }


        public Integer getState() {
                return this.state;
        }

        public void setState(Integer state) {
                this.state = state;
        }

}