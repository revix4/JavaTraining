package com.training.banking.Menus;

import com.training.banking.InputScanner;
import com.training.banking.Users.Role;
import com.training.banking.Users.User;
import com.training.banking.Users.UserList;

public class AdminMenu {
	
	public static void ManageAllMenu(UserList users, User current)
	{
		boolean quit = false;
		
		System.out.println("Hello " + current.getUsername());
		
		while(!quit)
		{
			System.out.println("Admin Management Menu.");
			String selection = InputScanner.getStringInput
					("Press V to view all user info\n"
							+ "Press W to withdraw from an account\n"
							+ "Press D to deposit from an account\n"
							+ "Press A to approve a customer\n"
							+ "Press R to close an user account\n"
							+ "Press Q to quit");
			
			if(selection.equals("V") || selection.equals("v"))
			{
				users.viewAccounts();
			}
			else if(selection.equals("W") || selection.equals("w"))
			{
				WithdrawelMenu(users);
			}
			else if(selection.equals("D") || selection.equals("d"))
			{
				DepositMenu(users);
			}
			else if(selection.equals("A") || selection.equals("a"))
			{
				users.viewAccounts(Role.Customer);
				String username = InputScanner.getStringInput("Enter the username you would like to approve.");
				users.approveUser(username);
			}
			else if(selection.equals("R") || selection.equals("r"))
			{
				RemoveUserMenu(users, current);
			}
			else if(selection.equals("Q") || selection.equals("q"))
			{
				quit = true;
			}
		}
	}
	
	private static void WithdrawelMenu(UserList users)
	{
		String selection = InputScanner.getStringInput("Enter the username you would like to withdraw from.");
		
		User user = users.getUser(selection);
		
		if(user != null)
		{
			double input = InputScanner.getDoubleInput("How much do you want to withdraw?");
			user.withdraw(input);
		}
		else
		{
			System.out.println("That user does not exist.");
		}
	}
	
	private static void DepositMenu(UserList users)
	{
		String selection = InputScanner.getStringInput("Enter the username you would like to deposit to.");
		
		User user = users.getUser(selection);
		
		if(user != null)
		{
			double input = InputScanner.getDoubleInput("How much do you want to deposit?");
			user.deposit(input);
		}
		else
		{
			System.out.println("That user does not exist.");
		}
	}
	
	private static void RemoveUserMenu(UserList users, User current)
	{
		String selection = InputScanner.getStringInput("Enter the username you would like to close.");
		
		if(!selection.equals(current.getUsername()))
		{
			users.removeUser(selection);
		}
		else
		{
			System.out.println("Please do not delete yourself.");
		}
	}
}
