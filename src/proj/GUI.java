package proj;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingWorker;
import javax.swing.Timer;

@SuppressWarnings("serial")
class GUI extends JPanel
{
	static int screenWidth = 1276;
	static int screenHeight = 720;
	static int[] listArr = new int[126];
	
	public void setItems(int[] listArr)
    {
        GUI.listArr = listArr;
        repaint();
    }
	
	public void sort() {
		new SortWorker(listArr).execute();
	}
	
	class SortWorker extends SwingWorker<Void, int[]> {
        private int[] items;

        public SortWorker(int[] unsortedItems) {
            items = Arrays.copyOf(unsortedItems, unsortedItems.length);
        }

        @Override
        protected Void doInBackground() {
            for (int i = 0; i < items.length; i++) {
    			for (int j = 0; j < items.length; j++) {
    				if (items[i] < items[j]) {
    					//swapping i and j
    					
    					int temp = items[i];
    					items[i] = items[j];
    					items[j] = temp;
    					
    					publish(Arrays.copyOf(items, items.length));
    					try {
    						Thread.sleep(1); 
    					} catch (Exception e) {}
    				}
    			}
    		}	

            return null;
        }

        @Override
        protected void process(List<int[]> list) {
            int[] items = list.get(list.size() - 1);
            setItems(items);
        }

        @Override
        protected void done() {}
    }
	

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
    
    //gives array numbers 1-126 (randomized)
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
    
    public static void showGUI() {
    	listArr = shuffleRectangles();
		JFrame frame = new JFrame();
		GUI gui = new GUI();
		gui.sort();
		
		
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







