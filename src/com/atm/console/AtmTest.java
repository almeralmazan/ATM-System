package com.atm.console;

import java.util.Scanner;

import com.atm.controller.Depositor;

public class AtmTest 
{
	public static void main(String[] args) throws InterruptedException 
	{
		Scanner sc = new Scanner(System.in);
		Depositor depositor = new Depositor();

		int choice;
		double amount;
		String oldPIN;
		String newPassword;
		String inputPIN;
		
		System.out.println("Welcome to AMA Bank");
		
		oldPIN = depositor.getPin();
		
		do {
			System.out.print("Enter your PIN: ");
			inputPIN = sc.next();
		} while( ! inputPIN.equals(oldPIN));
		
		do {
			displayMenu();
			
			System.out.println("\nSelect from menu by choosing");
			System.out.print("number then press enter: ");
			choice = sc.nextInt();
			
			switch(choice)
			{
				//---- WITHDRAW ----
				case 1:
					System.out.println("\n=== Withdrawal ===");
					System.out.print("Please enter amount: ");
					amount = sc.nextDouble();
					
					processFun("Processing transaction");
										  
					// If the amount entered is available
					if (amount < depositor.getBalance()) {
						depositor.setBalance(depositor.withdraw(amount));
						System.out.println("\nGet your cash\n");
						// do you want another transaction?
					} else {
						System.out.println("\nSorry your balance is not enough for this transaction.");
					}
					break;
				
				//---- DEPOSIT ----
				case 2:
					System.out.println("\n=== Deposit ===");
					System.out.print("Please enter amount: ");
					amount = sc.nextDouble();
					
					depositor.setBalance(depositor.getBalance() + amount);
					
					System.out.print("Do you want a receipt? [y/n]: ");
					String yOrN = sc.next();
					if ( yOrN.equals("y") ) {
						processFun("Printing");
					}
					System.out.println("\nYour current balance is P" + depositor.getBalance() + "\n");
					break;
				
				//---- GET BALANCE ----
				case 3:
					System.out.println("\n=== Inquire Balance ===");
					System.out.println("Your current balance is P" + depositor.getBalance() + "\n");
					break;
				
				//---- CHANGE PIN ----
				case 4:
					System.out.println("\n=== Change PIN ===");
					
					System.out.print("Enter old password: ");
					String temp = sc.next();
					
					 while ( ! temp.equals(oldPIN) ) {
							System.out.print("Please re-enter old password: ");
							temp = sc.next();
					} 
					
					 if (depositor.getPin().equals(temp)) {
						System.out.print("Enter your new password: ");
						newPassword = sc.next();
						depositor.setPin(newPassword);
						System.out.println("PIN changed.");
					}
					break;
					
				//---- EXIT ----
				case 5:
					System.out.println("\nGoodbye, have a nice day!!!");
					break;
			}
		} while(choice != 5);
	}

	// This is what I called FUN...
	private static void processFun(String message) throws InterruptedException
	{
		System.out.println(message + ", please wait");
		for (int i = 0; i < 5; i++) {
			Thread.sleep(1000);
			System.out.print(". ");
		}
	}

	private static void displayMenu() 
	{
		System.out.println("\n================");
		System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Get Balance");
        System.out.println("4. Change PIN");
        System.out.println("5. Exit");
        System.out.println("=================\n");
	}
	
}
