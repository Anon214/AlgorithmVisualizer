package algorithimPackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")

class DrawPanel extends JPanel
{
	static int screenWidth = 1276;
	static int screenHeight = 720;
	boolean shuffled = false;
	Timer timer;
    /**
	 * 
	 */
	
	int i = 0;
//    static int x = 0;
    public DrawPanel() {
        ActionListener animate = new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                repaint();
            }
        };
        timer = new Timer(1000, animate);
//        timer.start();
    }
    
    public void paintComponent(Graphics g) {
    	super.paintComponent(g);
		this.setBackground(Color.darkGray);
		Graphics2D g2d = (Graphics2D) g;
		int width = 10;
		int x = 0;
		int listArr[] = shuffleRectangles(width);
		
		//draws rectangles
//		System.out.println("repeat");
		if (shuffled == false) {
			
		}
		else {
			listArr = Algorithims.HeapSort(listArr);
		}
		
		for (int i = 0; i < (screenWidth - 15) / width; i++) {
			g2d.setPaint(Color.white);
			g2d.fillRect(x, (screenHeight - listArr[i]) - 40, width, listArr[i]);
			g2d.setPaint(Color.black);
			g2d.drawRect(x, (screenHeight - listArr[i]) - 40, width, listArr[i]);
			x += width;
			System.out.println(x);
		}
		
//		g2d.setPaint(Color.white);
//		g2d.fillRect(x, (screenHeight - listArr[i]) - 40, width, listArr[i]);
//		g2d.setPaint(Color.black);
//		g2d.drawRect(x, (screenHeight - listArr[i]) - 40, width, listArr[i]);
//		System.out.println(i);
//		if (i > 20) {
//			timer.stop();
//		}
//		i++;
//		x += 10;
    
    }
    
    //get numbers 1-126 random
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
	
public class GUI {
	static int screenWidth = 1276;
	static int screenHeight = 720;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DrawPanel panel = new DrawPanel();
		JFrame frame = new JFrame();
		frame.setTitle("Algorithim Visualizer");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(screenWidth, screenHeight); 
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.add(panel);
		
	}
	

}







