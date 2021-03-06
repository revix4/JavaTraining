package com.training.banking.Menus;

import com.training.banking.InputScanner;
import com.training.banking.Users.Role;
import com.training.banking.Users.User;
import com.training.banking.Users.UserList;

public class EmployeeMenu {
	
	public static void CustomerManageMenu(UserList users, User current)
	{
		boolean quit = false;
		
		System.out.println("Hello " + current.getUsername());
		
		while(!quit)
		{
			System.out.println("Customer Management Menu.");
			String selection = InputScanner.getStringInput
					("Press V to view customers info\n"
							+ "Press A to approve a customer\n"
							+ "Press Q to quit");
			
			if(selection.equals("V") || selection.equals("v"))
			{
				users.viewAccounts(Role.Customer);
			}
			else if(selection.equals("A") || selection.equals("a"))
			{
				users.viewAccounts(Role.Customer);
				String username = InputScanner.getStringInput("Enter the username you would like to approve.");
				users.approveUser(username);
			}
			else if(selection.equals("Q") || selection.equals("q"))
			{
				quit = true;
			}
		}
	}
}
