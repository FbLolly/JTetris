package mainPkg;

import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		JFrame frame = new JFrame("JTetris");
		
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new JTetris());
		frame.setVisible(true);
		frame.pack();
	}
}
//Copyright 2024 FbLolly
