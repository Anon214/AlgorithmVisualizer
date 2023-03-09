package algorithms;

import proj.GUI;
import proj.Methods;

public class HeapSort {

	public static void heapSort(int[] listArr, GUI gui) {
		int n = listArr.length;

	    // Build heap (rearrange array)
	    for (int i = n / 2 - 1; i >= 0; i--)
	        heapify(listArr, gui, n, i);

	    // One by one extract an element from heap
	    for (int i = n - 1; i > 0; i--) {
	        // Move current root to end
	    	
	    	Methods.swap(0, i);
	    	
	    	try {
				Thread.sleep(100); 
			} catch (Exception e) {}
			
			gui.refill(listArr);
	    	

	        // call heapify on the reduced heap
	        heapify(listArr, gui, i, 0);
	    }
	}
	
	private static void heapify(int[] arr, GUI gui, int n, int i) {
	    int largest = i; // Initialize largest as root
	    int l = 2 * i + 1; // left = 2*i + 1
	    int r = 2 * i + 2; // right = 2*i + 2

	    // If left child is larger than root
	    if (l < n && arr[l] > arr[largest])
	        largest = l;

	    // If right child is larger than largest so far
	    if (r < n && arr[r] > arr[largest])
	        largest = r;

	    // If largest is not root
	    if (largest != i) {
	        // swap arr[i] with arr[largest]
	        Methods.swap(i, largest);

	        try {
				Thread.sleep(50); 
			} catch (Exception e) {}
			
			gui.refill(arr);
	        
	        heapify(arr, gui, n, largest);
	    }
	}

}
