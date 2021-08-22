package com.training.banking;

import com.training.banking.Menus.AdminMenu;
import com.training.banking.Menus.CustomerMenu;
import com.training.banking.Menus.EmployeeMenu;
import com.training.banking.Users.Role;
import com.training.banking.Users.User;
import com.training.banking.Users.UserList;

public class BankingApp {

	public static void main(String[] args) {
		UserList users = new UserList();
		
		InputScanner.open();
		
		boolean quit = false;
		
		while(!quit)
		{
			System.out.println("Login Menu.");
			String selection = InputScanner.getStringInput("Press R to register\nPress L to login\nPress Q to quit");
			
			if(selection.equals("R") || selection.equals("r"))
			{
				String username = InputScanner.getStringInput("Enter your username.");
				
				String password = InputScanner.getStringInput("Enter your password.");
				
				if(users.register(username, password))
				{
					User current = users.getCurrentUser();
					if(current.getRole().equals(Role.Customer))
					{
						CustomerMenu.TransactionMenu(current);
					}
				}
			}
			else if(selection.equals("L") || selection.equals("l"))
			{
				String username = InputScanner.getStringInput("Enter your username.");
				
				String password = InputScanner.getStringInput("Enter your password.");
				
				if(users.login(username, password))
				{
					User current = users.getCurrentUser();
					if(current.getRole().equals(Role.Customer))
					{
						CustomerMenu.TransactionMenu(current);
					}
					else if(current.getRole().equals(Role.Employee))
					{
						EmployeeMenu.CustomerManageMenu(users, current);
					}
					else if(current.getRole().equals(Role.Admin))
					{
						AdminMenu.ManageAllMenu(users, current);
					}
				}
			}
			else if(selection.equals("Q") || selection.equals("q"))
			{
				System.out.println("Bye");
				quit = true;
			}
		}
		
		InputScanner.close();
		users.save();
	}

}
