package com.training.banking.Users;

import java.util.HashMap;

public class UserList {
	private HashMap<String, User> users;
	private User currentUser;
	
	public UserList() {
		users = new HashMap<String, User>();
	}
	
	public boolean register(String username, String password)
	{
		if(users.containsKey(username))
		{
			System.out.println("Username already exists.");
			return false;
		}
		else
		{
			User newUser = new User(username, password, Role.Customer);
			users.put(username, newUser);
			currentUser = newUser;
			return true;
		}
	}
	
	public boolean login(String username, String password)
	{
		if(users.containsKey(username))
		{
			User user = users.get(username);
			if(user.checkLogin(username, password))
			{
				currentUser = user;
				return true;
			}
			else
			{
				System.out.println("Username and password do not match.");
				return false;
			}
		}
		else
		{
			System.out.println("User does not exist.");
			return false;
		}
	}
	
	public User getCurrentUser()
	{
		return currentUser;
	}
}
