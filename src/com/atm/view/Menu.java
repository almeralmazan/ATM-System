package com.atm.view;

import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.atm.controller.Depositor;

public class Menu extends JFrame {
	private JPanel contentPane;

	private Depositor depositor;
	private String inputOldPIN;
	private String newPIN;
	
	public Menu() {
		depositor = new Depositor();
		setSize(168, 238);
		setResizable(false);
		setTitle("Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 142, 188);
		contentPane.add(panel);
		panel.setLayout(null);
		
		//-----------------------------------
		// Withdraw functionality
		//-----------------------------------
		JButton btnWithdrawal = new JButton("Withdrawal");
		btnWithdrawal.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				String inputValue = JOptionPane.showInputDialog("Please enter amount: ");
				
				if ( !isNum(inputValue) )
				{
					JOptionPane.showMessageDialog(null, "Not a valid number" );
				}
				else if ( inputValue == null)
				{
					JOptionPane.showMessageDialog(null, "You cancelled the transaction");
				}
				else if ( inputValue != null && isNum(inputValue) && Double.parseDouble(inputValue) < depositor.getBalance() )
				{
					JOptionPane.showMessageDialog(null, "Please get your cash!");
					depositor.setBalance(depositor.getBalance() - Double.parseDouble(inputValue));
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Sorry! Your balance is not enough for this transaction");
				}
			}
		});
		btnWithdrawal.setBounds(10, 11, 122, 33);
		panel.add(btnWithdrawal);
		
		//-----------------------------------
		// Deposit functionality
		//-----------------------------------
		JButton btnDeposit = new JButton("Deposit");
		btnDeposit.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				String inputValue = JOptionPane.showInputDialog("Please enter amount: ");
				if ( inputValue != null)
				{
					depositor.deposit(Double.parseDouble(inputValue));
					
					int response = JOptionPane.showConfirmDialog(
								null, "Do you want a receipt?", "Confirm",
								JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE
							);
	
					if (response == JOptionPane.NO_OPTION)
					{
						JOptionPane.showMessageDialog(null, "Your account balance is P" + depositor.getBalance() );
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Finished printing.... \nYour account balance is P" + depositor.getBalance() );
					}

				}
			}
		});
		btnDeposit.setBounds(10, 55, 122, 33);
		panel.add(btnDeposit);
		
		//-----------------------------------
		// Inquire Balance functionality
		//-----------------------------------
		JButton btnInquireBalance = new JButton("Inquire Balance");
		btnInquireBalance.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				JOptionPane.showMessageDialog(null, "Your current balance is P" + depositor.getBalance() );
			}
		});
		btnInquireBalance.setBounds(10, 99, 122, 33);
		panel.add(btnInquireBalance);
		
		//-----------------------------------
		// Change the stored old PIN
		//-----------------------------------
		JButton btnChangePin = new JButton("Change PIN");
		btnChangePin.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				inputOldPIN = JOptionPane.showInputDialog("Enter old password:");
				
				if (inputOldPIN != null && inputOldPIN.equals(depositor.getPin()))
				{
					newPIN = JOptionPane.showInputDialog("Enter your new password:");
					depositor.setPin(newPIN);
				}
				else
				{
					inputOldPIN = JOptionPane.showInputDialog("Please re-enter old password:");
					while( ! inputOldPIN.equals(depositor.getPin()))
					{
						inputOldPIN = JOptionPane.showInputDialog("Please re-enter old password:");
					}
					newPIN = JOptionPane.showInputDialog("Enter your new password:");
					depositor.setPin(newPIN);
				}
			}
		});
		btnChangePin.setBounds(10, 143, 122, 33);
		panel.add(btnChangePin);
	}
	
	//-----------------------------------
	// Return true if the value is a
	// number value otherwise false
	//-----------------------------------
	public boolean isNum(String s) 
	{
		try {
			Double.parseDouble(s);
		}
		catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

}
