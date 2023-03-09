package proj;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public
class GUI extends JPanel
{
	static int screenWidth = 1276;
	static int screenHeight = 720;
	static int[] listArr = new int[126];

    public void paintComponent(Graphics g) {
    	super.paintComponent(g);
		this.setBackground(Color.darkGray);
		int width = 10;
		int x = 0;
		for (int i = 0; i < (screenWidth - 15) / width; i++) {
			g.setColor(Color.white);
			g.fillRect(x, (screenHeight - listArr[i]) - 40, width, listArr[i]);
			g.setColor(Color.black);
			g.drawRect(x, (screenHeight - listArr[i]) - 40, width, listArr[i]);
			x += width;
		}
    }
    
	public void refill(int[] items) {
		GUI.listArr = items;
		repaint();
	}
        
    public static void showGUI() {
    	Methods method = new Methods();
    	listArr = Methods.shuffleRectangles();
		JFrame frame = new JFrame();
		GUI gui = new GUI();
		method.sorter(gui, listArr);
		
		
		frame.setTitle("Algorithim Visualizer");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(screenWidth, screenHeight); 
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.add(gui);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater( () -> showGUI() );
		
	}
	
}



