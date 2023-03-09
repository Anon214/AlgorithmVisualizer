package algorithms;

import proj.GUI;
import proj.Methods;

public class BubbleSort {
	public static void bubbleSort(int[] listArr, GUI gui) {
		int n = listArr.length;
	    for (int i = 0; i < n - 1; i++) {
	        for (int j = 0; j < n - i - 1; j++) {
	            if (listArr[j] > listArr[j + 1]) {
	            	Methods.swap(j, j + 1);
	            	try {
						Thread.sleep(5); 
					} catch (Exception e) {}
					
					gui.refill(listArr);
	            }
	        }
	    }
	}
}
