package proj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.SwingWorker;
import algorithms.HeapSort;
import algorithms.BubbleSort;
import algorithms.QuickSort;
import algorithms.SelectionSort;
import algorithms.HeapSort;

public class Methods {
	private SwingWorker<Void, Void> sort;
	
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
	
	public static void swap(int i, int j) {
		int temp = GUI.listArr[i];
		GUI.listArr[i] = GUI.listArr[j];
		GUI.listArr[j] = temp;
	}
	
	public void sorter(GUI gui, int[] listArr) {
		sort = new SwingWorker<>() {
			@Override			
			// change sorting method
			protected Void doInBackground() throws Exception {
				HeapSort.heapSort(listArr, gui);
//				QuickSort.quickSort(listArr, gui);
//				SelectionSort.selectionSort(listArr, gui);
//				BubbleSort.bubbleSort(listArr, gui);
				return null;
			}
		};	
		sort.execute();
	}
	
}
