package com.atm.main;

import javax.swing.UIManager;
import com.atm.view.WelcomeView;

public class Main {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			WelcomeView frame = new WelcomeView();
			frame.setVisible(true);
		} catch(Exception e) {
			System.out.println("Loading failed");
		}
	}
}
