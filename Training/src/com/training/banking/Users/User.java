package com.training.banking.Users;

import java.io.Serializable;

public class User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2552625019421227336L;
	private String username;
	private String password;
	private Role role;
	private int balance;
	private boolean approved;
	
	public User(String name, String pass, Role role)
	{
		username = name;
		password = pass;
		this.role = role;
		balance = 0;
		approved = false;
	}
	
	public User(String name, String pass, Role role, int balance)
	{
		username = name;
		password = pass;
		this.role = role;
		this.balance = balance;
		approved = false;
	}
	
	public String getUsername()
	{
		return username;
	}
	
	public Role getRole()
	{
		return role;
	}
	
	public double getBalance()
	{
		return balance;
	}
	
	public boolean isApproved()
	{
		return approved;
	}
	
	public void approve()
	{
		approved = true;
	}
	
	public boolean checkLogin(String name, String pass)
	{
		return username.equals(name) && password.equals(pass);
	}
	
	public void deposit(double amount)
	{
		balance += amount;
		System.out.println("Your new balance is " + balance);
	}
	
	public void withdraw(double amount)
	{
		if(amount > balance)
		{
			System.out.println("You cannot withdraw more then you have in your account.");
		}
		else
		{
			balance -= amount;
			System.out.println("Your new balance is " + balance);
		}
	}
}
