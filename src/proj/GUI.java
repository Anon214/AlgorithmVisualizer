package proj;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
class GUI extends JPanel
{
	static int screenWidth = 1276;
	static int screenHeight = 720;
	boolean isSwapped = false;
	Timer timer;
	static int[] listArr = new int[126];
	int i = 0;

	//630 is max num
	
//    public void drawPanel() {
//        ActionListener action = new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//            	
//            	repaint();
//            	System.out.println("repained");
//            }
//        };
//        timer = new Timer(1000, action);
//        timer.start();
//    }

    public void paintComponent(Graphics g) {
    	super.paintComponent(g);
		this.setBackground(Color.darkGray);
		Graphics2D g2d = (Graphics2D) g;
		int width = 10;
		int x = 0;
		Algorithims.HeapSort(listArr);
		for (int i = 0; i < (screenWidth - 15) / width; i++) {
			g2d.setPaint(Color.white);
			g2d.fillRect(x, (screenHeight - listArr[i]) - 40, width, listArr[i]);
			g2d.setPaint(Color.black);
			g2d.drawRect(x, (screenHeight - listArr[i]) - 40, width, listArr[i]);
			x += width;
		}
		
    
    }
    
    public void swap(int i, int j) {
    	int temp = listArr[i];
    	listArr[i] = listArr[j];
    	listArr[j] = temp; 
    	System.out.println("e");
    	refill(10000);
    	
    }
    
    public void refill(int ms) {
    	Thread t1 = new Thread(new Runnable() {
    	    @Override
    	    public void run() {
    	        repaint();
    	        try {
					Thread.sleep(ms);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    	    }
    	});  
    	t1.start();
    }
    
    //gives array numbers 1-126 random
    public static int[] shuffleRectangles() { 
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		listArr = shuffleRectangles();
		JFrame frame = new JFrame();
		GUI gui = new GUI();
		
		
//		gui.drawPanel();
		frame.setTitle("Algorithim Visualizer");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(screenWidth, screenHeight); 
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.add(gui);
		
	}
	

}







