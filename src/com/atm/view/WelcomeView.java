package com.atm.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import com.atm.controller.Depositor;

public class WelcomeView extends JFrame {

	private JPanel contentPane;
	private JPasswordField pinTextField;

	private Toolkit toolkit;
	private Dimension size;
	/**
	 * Create the frame.
	 */
	public WelcomeView()
	{
		centerScreen();
		setTitle("Welcome");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 318, 199);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblWelcome = new JLabel("Welcome to AMA Bank");
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblWelcome.setBounds(55, 28, 209, 33);
		panel.add(lblWelcome);
		
		JLabel lblPleaseEnterPIN = new JLabel("Please enter your PIN:");
		lblPleaseEnterPIN.setBounds(101, 93, 116, 14);
		panel.add(lblPleaseEnterPIN);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				Depositor depositor = new Depositor();
				String storedPIN = depositor.getPin();
				String pinInputted = String.valueOf(pinTextField.getPassword());
				
				if ( storedPIN.equals(pinInputted) ) {
					Menu menu = new Menu();
					setVisible(false);
					menu.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Incorrect PIN! Please try again...");
				}
				
			}
		});
		btnOk.setBounds(115, 149, 89, 23);
		panel.add(btnOk);
		
		pinTextField = new JPasswordField();
		pinTextField.setBounds(113, 118, 93, 20);
		panel.add(pinTextField);
	}
	
	//-------------------------------------
	// Centers the frame or window screen
	//-------------------------------------
	private void centerScreen() 
	{
		toolkit = getToolkit();
		size = toolkit.getScreenSize();
		setSize(349, 248);
		setLocation( (size.width/2 - getWidth()/2), (size.height/2 - getHeight()/2) );
	}
}
