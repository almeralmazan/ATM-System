package com.atm.controller;

public class Atm 
{
	// This is what I called FUN...
	public static void processFun(String message) throws InterruptedException
	{
		System.out.println(message + ", please wait");
		for (int i = 0; i < 5; i++) {
			Thread.sleep(1000);
			System.out.print(". ");
		}
	}
	
	public static void displayMenu() 
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
