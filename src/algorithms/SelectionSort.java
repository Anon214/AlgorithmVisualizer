package algorithms;

import proj.GUI;
import proj.Methods;

public class SelectionSort {
	public static void selectionSort(int[] listArr, GUI gui) {

	    for (int i = 0; i < listArr.length - 1; i++) {
	        int minIndex = i;
	        for (int j = i + 1; j < listArr.length; j++) {
	            if (listArr[j] < listArr[minIndex]) {
	                minIndex = j;
	            }
	        }
	        
	        Methods.swap(i, minIndex);
	        
	        try {
				Thread.sleep(50); 
			} catch (Exception e) {}
			
			gui.refill(listArr);
	    }

	}
}
