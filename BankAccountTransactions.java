import java.util.Scanner;

/* Name: BankAccountTransactions (Exercise) Project
 * Date: 10/12/2017
 * Author: Rupali
 * This class has functionality of bank operations such as deposit, withdraw,
 * balance and exit system from command line
 * This class has following variables and methods
 * private static double balance;
 * private static void AccountOperations()
 * private static boolean ValidAmount(String amount)
 * private static void Deposit()
 * private static void Withdraw()
 */

public class BankAccountTransactions {

	//Stores the balance of account
	private static double balance;
	private static boolean depositStatus, withdrawStatus;
	
	//AcountOperations includes the main menu of operations
	private static void AccountOperations()
	{
		try
		{
			Scanner operationsInput = new Scanner(System.in);
		    while(true)
		    {
		    	System.out.println("Please enter in command(Deposit, Withdraw, Balance, Exit):");
			    String commandInput = operationsInput.next();
			    if(commandInput.equalsIgnoreCase("Deposit"))
				    depositStatus = Deposit();
			    if(commandInput.equalsIgnoreCase("Withdraw"))
				    withdrawStatus = Withdraw();
		        if(commandInput.equalsIgnoreCase("Balance"))
				    System.out.println("The current balance is: $" + balance + ".");
		        if(commandInput.equalsIgnoreCase("Exit"))
			    	System.exit(0);
	     	}
		}
		catch(Exception ex)
		{
			System.out.println("In AccountOperations()method, exception " + ex);
		}
	}
	
	//ValidAmount checks if amount entered is valid or not.
	//If valid, returns true otherwise false
	private static boolean ValidAmount(String amount)
	{
		try
		{
			double money = Double.parseDouble(amount);
			if (money <= 0)
			   	 return false;
			else
			{
				 String MoneyAmount = Double.toString(money);
				 int integerPlaces = MoneyAmount.indexOf('.');
				 int decimalPlaces = MoneyAmount.length() - integerPlaces - 1;
			     if (decimalPlaces <= 2)
				 	  return true;
				 else
				 	  return false;
			}
		}
		catch(Exception e)
		{
			System.out.println("In ValidAmount(), Exception: " + e);
			return false;
		}
    }
	
	//Method, Deposit() deposits amount entered by user to the account
	private static boolean Deposit()
	{
		try
		{
			Scanner depositAmount = new Scanner(System.in);
			while(true)
			{
				System.out.println("Please enter an amount to deposit");
			    String depositInput = depositAmount.next();
			    if (ValidAmount(depositInput))
			    {
			    	balance = balance + Double.parseDouble(depositInput);
				    System.out.println ("Amount is deposited.");
			    	return true;
			    }
			    else
			   		System.out.println ("Invalid amount");
		    }
		}
		catch(Exception ex)
		{
			System.out.println("In Deposit(), Exception: " + ex);
			return false;
		}
	}
	
	//Withdraw()withdraws amount entered by user from the account
	private static boolean Withdraw()
	{
		try
		{
			Scanner withdrawAmount = new Scanner(System.in);
			while(true)
			{
				System.out.println("Please enter an amount to withdraw");
			    String withdrawInput = withdrawAmount.next();
			    if (ValidAmount(withdrawInput))
			    {
			    	if (balance < Double.parseDouble(withdrawInput))
			    		System.out.println("Withdraw amount is greater than balance");
			    	else
				    {
			    		balance = balance - Double.parseDouble(withdrawInput);
				        System.out.println ("Amount is withdrawn.");
			      	    return true;
				    }
			   }
			   else
				   System.out.println ("Invalid amount");
			}
		}
		catch(Exception ex)
		{
			System.out.println("In Withdraw(), Exception: " + ex);
			return false;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        AccountOperations();
	}

}
