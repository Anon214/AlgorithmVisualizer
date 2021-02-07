package algorithimPackage;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GUI extends JPanel{
	
	static int screenWidth = 1276;
	static int screenHeight = 720;
	
	public void paintComponent(Graphics g) {
		//height has 40 pixel difference
		//width has 15 pixel difference
		super.paintComponent(g);
		this.setBackground(Color.darkGray);
		int width = 10;
		int x = 0;
		g.setColor(Color.white);
		
		//draws rectangles
		LinkedList<Integer> listPop = shuffleRectangles(width);
		int listArr[] = new int[listPop.size()];
		
		for (int i = 0; i < (screenWidth - 15) / width; i++) {
			g.setColor(Color.white);
			g.fillRect(x, (screenHeight - listPop.getFirst()) - 40, width, listPop.getFirst()); 
			g.setColor(Color.black);
			g.drawRect(x, (screenHeight - listPop.getFirst()) - 40, width, listPop.getFirst());
			listArr[i] = listPop.getFirst(); 
			listPop.pop();
			x += width;
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GUI guiObj = new GUI();
		
		JFrame frame = new JFrame();
		frame.setTitle("Algorithim Visualizer");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(screenWidth, screenHeight); 
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		frame.add(guiObj);

	}
	
	public static LinkedList<Integer> shuffleRectangles(int width) { 
		LinkedList<Integer> list = new LinkedList<Integer>();
		int x = 5;
		for (int i = 0; i < 126; i++) {
			list.add(x);
			x += 5;
		}
		Collections.shuffle(list);
		return list;
		
	}
	

}







