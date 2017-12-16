package cn.gov.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Book implements Serializable {

        private Integer id;
        private String ASIN;
        private String title;
        private String imageFile;
        private String publisher;
        private double price;

        // 构造方法
        public Book() {
        }

        public Book(Integer id, String ASIN, String title, String imageFile,
                        String publisher, double price) {
                super();
                this.id = id;
                this.ASIN = ASIN;
                this.title = title;
                this.imageFile = imageFile;
                this.publisher = publisher;
                this.price = price;
        }


        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
        }

        public String getASIN() {
                return ASIN;
        }

        public void setASIN(String aSIN) {
                ASIN = aSIN;
        }

        /**
         * @return the title
         */
        public String getTitle() {
                return title;
        }

        /**
         * @param title
         *                the title to set
         */
        public void setTitle(String title) {
                this.title = title;
        }

        /**
         * @return the imageFile
         */
        public String getImageFile() {
                return imageFile;
        }

        /**
         * @param imageFile
         *                the imageFile to set
         */
        public void setImageFile(String imageFile) {
                this.imageFile = imageFile;
        }

        /**
         * @return the publisherID
         */
        public String getPublisher() {
                return publisher;
        }

        /**
         * @param publisherID
         *                the publisherID to set
         */
        public void setPublisher(String publisher) {
                this.publisher = publisher;
        }

        /**
         * @return the price
         */
        public double getPrice() {
                return price;
        }

        /**
         * @param price
         *                the price to set
         */
        public void setPrice(double price) {
                this.price = price;
        }

}
