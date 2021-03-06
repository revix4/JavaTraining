package com.training.banking.Users;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class UserList {
	private HashMap<String, User> users;
	private User currentUser;
	
	public UserList() {
		users = new HashMap<String, User>();
		this.load();
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
	
	public void save()
	{
		try
		{
			FileOutputStream fout = new FileOutputStream("Users.ser");
			ObjectOutputStream out = new ObjectOutputStream(fout);
			for(User user:users.values())
			{
				out.writeObject(user);
			}
			out.close();
		}
		catch(IOException e)
		{
			System.err.println("Unable to save users");
			e.printStackTrace();
		}
	}
	
	public void load()
	{
		try
		{
			FileInputStream fin = new FileInputStream("Users.ser");
			ObjectInputStream in = new ObjectInputStream(fin);
			
			boolean eof = false;
			while(!eof)
			{
				User user = (User)in.readObject();
				if(user != null)
				{
					users.put(user.getUsername(), user);
				}
				else
				{
					eof = true;
				}
			}
			
			in.close();
		}
		catch(EOFException e)
		{
			System.out.println("Reached end of file");
		}
		catch(IOException e)
		{
			System.out.println("IOexception " + e.getMessage());
		} 
		catch (ClassNotFoundException e) 
		{
			System.out.println("ClassNotFoundException" + e.getMessage());
		}
	}
	
	public User getCurrentUser()
	{
		return currentUser;
	}
	
	public User getUser(String username)
	{
		if(users.containsKey(username))
		{
			return users.get(username);
		}
		else
		{
			return null;
		}
	}
	
	public void viewAccounts(Role role)
	{
		for(User user:users.values())
		{
			if(user.getRole().equals(role))
			{
				System.out.println("User name: " + user.getUsername()
									+ " Account balance: " + user.getBalance()
									+ " Approved: "+ user.isApproved());
			}
		}
	}
	
	public void viewAccounts()
	{
		for(User user:users.values())
		{
			System.out.println("User name: " + user.getUsername()
								+ " Account balance: " + user.getBalance()
								+ " Role: " + user.getRole()
								+ " Approved: "+ user.isApproved());
		}
	}
	
	public void removeUser(String username)
	{
		if(users.containsKey(username))
		{
			users.remove(username);
		}
		else
		{
			System.out.println("That user does not exist");
		}
	}
	
	public void approveUser(String username)
	{
		if(users.containsKey(username))
		{
			users.get(username).approve();;
		}
		else
		{
			System.out.println("That user does not exist");
		}
	}
}
