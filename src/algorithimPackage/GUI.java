package algorithimPackage;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI extends JPanel{
	
	static int screenWidth = 1276;
	static int screenHeight = 720;
	
	public void paintComponent(Graphics g) {
		//height has 40 pixel difference
		//width has 15 pixel difference
		super.paintComponent(g);
		this.setBackground(Color.darkGray);
		int length = 5;
		int x = 0;
		for (int i = 0; i < screenWidth/10; i++) {
			g.setColor(Color.white);
			g.fillRect(x, (screenHeight - length) - 40, 10, length); 
			g.setColor(Color.black);
			g.drawRect(x, (screenHeight - length) - 40, 10, length);
			length += 5;
			x += 10;
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GUI guiObj = new GUI();
		
		JFrame frame = new JFrame();
		frame.setTitle("Algorithim Visualizer");
		frame.setSize(screenWidth, screenHeight); //720
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(guiObj);
		frame.setLocationRelativeTo(null);
	}

}
