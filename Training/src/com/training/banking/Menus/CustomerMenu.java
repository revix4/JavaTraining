package com.training.banking.Menus;

import com.training.banking.InputScanner;
import com.training.banking.Users.User;

public class CustomerMenu {
	public static void TransactionMenu(User currentUser)
	{
		boolean quit = false;
		
		System.out.println("Hello " + currentUser.getUsername());
		
		while(!quit)
		{
			System.out.println("Transaction Menu.");
			String selection = InputScanner.getStringInput
					("Press D to deposit funds\n"
							+ "Press W to withdraw funds\n"
							+ "Press Q to quit");
			
			if(selection.equals("Q") || selection.equals("q"))
			{
				quit = true;
			}
			else if(currentUser.isApproved())
			{
				if(selection.equals("D") || selection.equals("d"))
				{
					double input = InputScanner.getDoubleInput("How much do you want to deposit?");
					currentUser.deposit(input);
				}
				else if(selection.equals("W") || selection.equals("w"))
				{
					double input = InputScanner.getDoubleInput("How much do you want to withdraw?");
					currentUser.withdraw(input);
				}
			}
			else
			{
				System.out.println("Your account is still awaiting approval.");
			}
		}
	}
}
