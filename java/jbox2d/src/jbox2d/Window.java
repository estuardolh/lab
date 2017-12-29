package jbox2d;

import java.awt.Button;
import java.awt.Color;

import javax.swing.JFrame;


public class Window extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Window() {
		this.setSize(800,800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		
		this.setBackground(Color.WHITE);
		
		new SandBox(this).start();
	}
}
