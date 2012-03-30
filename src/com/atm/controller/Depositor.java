package com.atm.controller;

public class Depositor 
{
	private double balance;
	private String pin;
	
	public Depositor() {
		setBalance(1000);
		setPin("2012");
	}

	public double getBalance() 				{ return balance; }
	public void setBalance(double balance) 	{ this.balance = balance; }
	public String getPin() 					{ return pin; }
	public void setPin(String pin) 			{ this.pin = pin; }
	public double withdraw(double amount) 	{ return (balance -= amount); }
	public double deposit(double amount) 	{ return (balance += amount); }
	
	// Used only for testing
	public String toString() 				{ return "Balance is " + getBalance(); }
}