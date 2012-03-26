package com.atm.controller;

public class Depositor 
{
	private double balance;
	private String pin;
	
	public Depositor() {
		balance = 1000.00;
		pin = "2012";
	}

	public double getBalance() 				{ return balance; }
	public void setBalance(double balance) 	{ this.balance = balance; }
	public String getPin() 					{ return pin; }
	public void setPin(String pin) 			{ this.pin = pin; }

	public double withdraw(double amount) { 
		balance -= amount; 
		return balance; 
	}
	
	public double deposit(double amount) { 
		balance += amount; 
		return balance; 
	}
	
	// Used only for testing
	public String toString() 				{ return "Balance is " + getBalance(); }
}