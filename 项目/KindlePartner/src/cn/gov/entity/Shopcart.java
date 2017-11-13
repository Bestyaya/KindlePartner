package cn.gov.entity;

/**
 * Shopcart entity. @author MyEclipse Persistence Tools
 */

public class Shopcart implements java.io.Serializable {

	// Fields

	private String id;
	private Book book;
	private Integer number;
	private Double total;

	// Constructors

	/** default constructor */
	public Shopcart() {
	}

	/** minimal constructor */
	public Shopcart(String id) {
		this.id = id;
	}

	/** full constructor */
	public Shopcart(String id, Book book, Integer number, Double total) {
		this.id = id;
		this.book = book;
		this.number = number;
		this.total = total;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Book getBook() {
		return this.book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Integer getNumber() {
		return this.number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Double getTotal() {
		return this.total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

}