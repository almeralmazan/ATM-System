package com.utility;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class WinUtil extends JFrame
{
	private static Toolkit toolkit;
	private static Dimension size;
	
	public static void centerScreen(JFrame frame, int width, int height)
	{
		toolkit = frame.getToolkit();
		size = toolkit.getScreenSize();
		frame.setSize(168, 238);
		frame.setLocation( (size.width/2 - frame.getWidth()/2), (size.height/2 - frame.getHeight()/2) );
	}
}
