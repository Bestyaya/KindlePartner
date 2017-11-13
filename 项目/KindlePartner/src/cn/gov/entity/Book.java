package cn.gov.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Book entity. @author MyEclipse Persistence Tools
 */

public class Book implements java.io.Serializable {

	// Fields

	private String asin;
	private String title;
	private String author;
	private String imageSrc;
	private String summary;
	private Double price;
	private Set shopcarts = new HashSet(0);

	// Constructors

	/** default constructor */
	public Book() {
	}

	/** minimal constructor */
	public Book(String asin) {
		this.asin = asin;
	}

	/** full constructor */
	public Book(String asin, String title, String author, String imageSrc,
			String summary, Double price, Set shopcarts) {
		this.asin = asin;
		this.title = title;
		this.author = author;
		this.imageSrc = imageSrc;
		this.summary = summary;
		this.price = price;
		this.shopcarts = shopcarts;
	}

	// Property accessors

	public String getAsin() {
		return this.asin;
	}

	public void setAsin(String asin) {
		this.asin = asin;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getImageSrc() {
		return this.imageSrc;
	}

	public void setImageSrc(String imageSrc) {
		this.imageSrc = imageSrc;
	}

	public String getSummary() {
		return this.summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Set getShopcarts() {
		return this.shopcarts;
	}

	public void setShopcarts(Set shopcarts) {
		this.shopcarts = shopcarts;
	}

}