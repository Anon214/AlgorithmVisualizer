package proj;

public class Algorithims {

	public static void HeapSort(int[] array) {
		GUI gui = new GUI();
		//idea: put array of swap index numbers then use those inside actionPerformed method
		//possibly could implement hash table
		//new idea: have function go back to GUI to change and repaint it over there
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (array[i] < array[j]) {
					//swapping i and j
					gui.swap(i, j);
				}
			}
		}
		
		
	}

}
