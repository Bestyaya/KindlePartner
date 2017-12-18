package cn.gov.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields
	private String username;
	private String password;
	private Integer vip;
	private Integer id;
	private String email;
	private Double balance;
	private Integer state;

	// Constructors

	/** default constructor */
	public User() {
	}

	public User(String password, Integer vip) {
		this.password = password;
		this.vip = vip;
	}

	public User(String password, Integer vip, Double balance) {
		this.password = password;
		this.vip = vip;
		this.balance = balance;
	}

	public User(String username, String password, Integer vip, Double balance) {
		this.username = username;
		this.password = password;
		this.vip = vip;
		this.balance = balance;
	}

	public User(String username, String password, Integer vip, Double balance,
			String email) {
		this.email = email;
		this.username = username;
		this.password = password;
		this.vip = vip;
		this.balance = balance;
	}

	public User(Integer id, String username, String password, Integer vip,
			Double balance, String email) {
		this.id = id;
		this.email = email;
		this.username = username;
		this.password = password;
		this.vip = vip;
		this.balance = balance;
	}

	// Property accessors
	public Integer getId() {
		return id;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getVip() {
		return this.vip;
	}

	public void setVip(Integer vip) {
		this.vip = vip;
	}

}