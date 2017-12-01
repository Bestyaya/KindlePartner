package cn.gov.entity;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private String username;
	private String password;
	private Integer vip;
	private Double balance;

	// Constructors

        /** default constructor */
	public User() {
	}

	/** full constructor */
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
	        this.username =username;
                this.password = password;
                this.vip = vip;
                this.balance = balance;
        }

	// Property accessors

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