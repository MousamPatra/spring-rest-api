package com.oneplace.fop.model;

public class UserDTO {

	private int id;
	private String name;
	private double walletBalance;
	
	public UserDTO(int id, String name, double walletBalance) {
		super();
		this.id = id;
		this.name = name;
		this.walletBalance = walletBalance;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getWalletBalance() {
		return walletBalance;
	}
	public void setWalletBalance(double walletBalance) {
		this.walletBalance = walletBalance;
	}
	@Override
	public String toString() {
		return "UserController [id=" + id + ", name=" + name + ", walletBalance=" + walletBalance + "]";
	}


}
