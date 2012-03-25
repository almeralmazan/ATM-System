package com.atm.view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.atm.controller.Depositor;

public class Menu extends JFrame {

	private JPanel contentPane;

	private Toolkit toolkit;
	private Dimension size;
	private Depositor depositor;
	
	/**
	 * Create the frame.
	 */
	public Menu() 
	{
		centerScreen();
		depositor = new Depositor();
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
		
		JButton btnWithdrawal = new JButton("Withdrawal");
		btnWithdrawal.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				/*WithdrawView wv = new WithdrawView();
				setVisible(false);
				wv.setVisible(true);*/
				
			}
		});
		btnWithdrawal.setBounds(10, 11, 122, 33);
		panel.add(btnWithdrawal);
		
		JButton btnDeposit = new JButton("Deposit");
		btnDeposit.setBounds(10, 55, 122, 33);
		panel.add(btnDeposit);
		
		JButton btnInquireBalance = new JButton("Inquire Balance");
		btnInquireBalance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Your current balance is P" + depositor.getBalance() );
			}
		});
		btnInquireBalance.setBounds(10, 99, 122, 33);
		panel.add(btnInquireBalance);
		
		JButton btnChangePin = new JButton("Change PIN");
		btnChangePin.setBounds(10, 143, 122, 33);
		panel.add(btnChangePin);
	}
	
	public boolean isNum(String s) 
	{
		try 
		{
			Double.parseDouble(s);
		}
		catch (NumberFormatException nfe) 
		{
			return false;
		}
		return true;
	}

	private void centerScreen() 
	{
		toolkit = getToolkit();
		size = toolkit.getScreenSize();
		setSize(168, 238);
		setLocation( (size.width/2 - getWidth()/2), (size.height/2 - getHeight()/2) );
	}
}
