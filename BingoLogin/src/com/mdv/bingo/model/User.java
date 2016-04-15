package com.mdv.bingo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name = "user")
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5108239992204609890L;

	@Id
	private long id;
	
	@NotEmpty
	@Size(min=2, max=50)
	private String username;
	//@Size(min=4, max=20, message = "Please enter your email addresss.")
	@NotEmpty
	@Size(min=4, max=50)
	private String password;
	/*private double cashBalance;
	private double winBalance;*/
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	/*public double getCashBalance() {
		return cashBalance;
	}
	public void setCashBalance(double cashBalance) {
		this.cashBalance = cashBalance;
	}
	public double getWinBalance() {
		return winBalance;
	}
	public void setWinBalance(double winBalance) {
		this.winBalance = winBalance;
	}	*/
}
