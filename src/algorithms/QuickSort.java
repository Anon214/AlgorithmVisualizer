package algorithms;

import proj.GUI;
import proj.Methods;

public class QuickSort {
	public static void quickSort(int[] listArr, GUI gui) {
		int low = 0;
		int high = listArr.length - 1;
		quick(listArr, gui, low, high);
	}
	
	public static void quick(int[] arr, GUI gui, int low, int high) {
	    if (low < high) {
	        int pi = partition(arr, gui, low, high);
	        
	        quick(arr, gui, low, pi - 1);
	        quick(arr, gui, pi + 1, high);
	    }
	}
	
	private static int partition(int[] arr, GUI gui, int low, int high) {
	    int pivot = arr[high];
	    
	    int i = low - 1;

	    for (int j = low; j < high; j++) {
	        if (arr[j] < pivot) {
	            i++;
	            int temp = arr[i];
	            arr[i] = arr[j];
	            arr[j] = temp;
	        }
	    }
	    Methods.swap(i + 1, high);
	    try {
			Thread.sleep(50); 
		} catch (Exception e) {}
		
		gui.refill(arr);
	    
	    return i + 1;
	}

}
