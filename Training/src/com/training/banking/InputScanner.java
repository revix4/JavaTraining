package com.training.banking;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputScanner {
	private static Scanner scan;

	public InputScanner()
	{
		
	}
	
	public static void open()
	{
		scan = new Scanner(System.in);
	}
	
	public static void close()
	{
		scan.close();
	}
	
	public static String getStringInput(String message)
	{
		System.out.println(message);
		
		boolean valid = false;
		String input = "";
		
		while(!valid)
		{
			try
			{
				input = scan.nextLine();
				if(input != "")
				{
					valid = true;
				}
				else
				{
					System.out.println("Invalid input, please do not input an empty line.");
				}
			}
			catch(Exception e)
			{
				valid = false;
				System.out.println("Invalid input, try again.");
			}
		}
		
		return input.trim();
	}
	
	public static double getDoubleInput(String message)
	{
		System.out.println(message);
		
		boolean valid = false;
		double input = 0.0;
		
		while(!valid)
		{
			try
			{
				input = scan.nextDouble();
				
				if(input > 0.0)
				{
					valid = true;
				}
				else
				{
					System.out.println("Invalid input, please input a positive number.");
				}
			}
			catch(InputMismatchException e)
			{
				valid = false;
				System.out.println("Invalid input, please input a number.");
			}
			catch(Exception e)
			{
				valid = false;
				System.out.println("Invalid input, try again.");
			}
			scan.nextLine();
		}
		
		return input;
	}
}
