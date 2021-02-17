package algorithimPackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GUI extends JPanel{
	static int screenWidth = 1276;
	static int screenHeight = 720;
	boolean shuffled = false;

	public void paintComponent(Graphics g) {
		//height has 40 pixel difference
		//width has 15 pixel difference
		super.paintComponent(g);
		this.setBackground(Color.darkGray);
		Graphics2D g2d = (Graphics2D) g;
		
		int width = 10;
		int x = 0;
		int listArr[] = shuffleRectangles(width);
		
		//draws rectangles
		

		if (shuffled == false) {
			for (int i = 0; i < (screenWidth - 15) / width; i++) {
				System.out.print("Went through");
				g2d.setPaint(Color.white);
				g2d.fillRect(x, (screenHeight - listArr[i]) - 40, width, listArr[i]);
				g2d.setPaint(Color.black);
				g2d.drawRect(x, (screenHeight - listArr[i]) - 40, width, listArr[i]);
				x += width;
			}
		}
		else {
			listArr = Algorithims.HeapSort(listArr);
		}
		refill(g2d, listArr, width, x);
		
	}
	
	public void refill(Graphics2D g2d, int listArr[], int width, int x) {
		this.shuffled = true;
		for (int i = 0; i < (screenWidth - 15) / width; i++) {
			g2d.setPaint(Color.white);
			g2d.fillRect(x, (screenHeight - listArr[i]) - 40, width, listArr[i]);
			g2d.setPaint(Color.black);
			g2d.drawRect(x, (screenHeight - listArr[i]) - 40, width, listArr[i]);
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
	
	public static int[] shuffleRectangles(int width) { 
		List<Integer> list = new ArrayList<>();
		int arr[] = new int[126];
		int x = 5;
		for (int i = 0; i < 126; i++) {
			list.add(x);
			x += 5;
		}
		
		Collections.shuffle(list);
		
		for (int i = 0; i < 126; i++) {
			arr[i] = list.get(i);
		}

		return arr;
		
	}
	

}







