package QuickSort;

import java.util.Random;

public class QuickSort {

	public static void main(String[] args) {
	
		QuickSortOptimization test = new QuickSortOptimization();

		System.out.println("***************************************************************\n" +
				" Part1.java\n" + 
				" CMIS 350 7980 Project 2\n" +
				" Purpose: This program test quicksort and the two optimization  methods.\n" +
				"          one that uses insertion and bubblesort a cutoff of 10\n" + 
				" Author Dakin T. Werneburg\n" +
				" Version 1.0 4/11/2015\n" +
				" ****************************************************************\n\n");

		//QuickSort: Creates array and displays before and after sort
		System.out.println("QuickSort BEFORE: ");
		int [] array1 = test.randomArray(100, 99);
		test.displayArray(array1);
		System.out.println("\n\nQuickSort AFTER: ");
		test.quickSort(array1, 0, array1.length-1);
		test.displayArray(array1);

		//QuickSort optimized with Insertion Sort: Creates array and displays before and after sort
		System.out.println("\n________________________________________________________________________________________________\n" +
				"Qsopt1 BEFORE: ");
		int [] array2 = test.randomArray(100, 999);
		test.displayArray(array2);
		System.out.println("\n\nQsopt1 AFTER: ");
		test.qSortOptimizedInsertion(array2, 0, array1.length-1);
		test.displayArray(array2);
		
		//QuickSort optimized with Bubble Sort: Creates array and displays before and after sort
		System.out.println("\n________________________________________________________________________________________________\n" +
				"Qsopt2 BEFORE: ");
		int [] array3 = test.randomArray(100, 999);
		test.displayArray(array3);
		System.out.println("\n\nQsopt2 AFTER: ");
		test.qSortOptimizedBubble(array3, 0, array1.length-1);
		test.displayArray(array3);
	}
	

}

class QuickSortOptimization{
	private final int CUTOFF = 10;

	
	//Simple quickSort 
	public void quickSort(int[] array, int left, int right) {
		
		//Base Case returns if left pointer crosses right pointer
		if (left >= right) {
            return;
        }
		
		//Select pivot as middle index
		int middle = left + (right - left) / 2;
		int pivot = array[middle];

		/* Partitions array into two subarrays.  By comparing each value
		 * as the pointers move towards each other it puts values
		 * less than pivot on the left and values greater values on the right.
		 */
		int i = left, j = right;
		while (i <= j) {	
			while (array[i] < pivot) 
				i++;
			while (array[j] > pivot) 
				j--;
			if (i <= j) {
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				i++;
				j--;
			}
		}
		
		//Recursively sorts each subarray
		if (left < j)
			quickSort(array, left, j);
		if (right > i)
			quickSort(array, i, right);
	}
	
	
	/* Executes QuickSort for the partitions of size larger 
	 * than the cutoff and executes Insertion Sort for sorting the 
	 * partitions of size less than or equal to the cutoff value. 
	 */
	public void qSortOptimizedInsertion(int[] array, int left, int right) {
		if ((right - left) < CUTOFF)
			insertionSort(array,left, right);

		//Select pivot as middle index
		int middle = left + (right - left) / 2;
		int pivot = array[middle];

		//Partition
		int i = left, j = right;
		while (i <= j) {	
			while (array[i] < pivot) 
				i++;
			while (array[j] > pivot) 
				j--;
			if (i <= j) {
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				i++;
				j--;
			}
		}

		//Recursively sorts each subarray
		if (left < j)
			qSortOptimizedInsertion(array, left, j);
		if (right > i)
			qSortOptimizedInsertion(array, i, right);
	}
	
	
	
	/* QSopt1 executes QuickSort for the partitions of size larger 
	 * than the cutoff and executes Insertion Sort for sorting the 
	 * partitions of size less than or equal to the cutoff value. 
	 */
	public void qSortOptimizedBubble(int[] array, int left, int right) {
		if ((right - left) < CUTOFF)
			bubbleSort(array);

		//Select pivot as middle index
		int middle = left + (right - left) / 2;
		int pivot = array[middle];

		//Partition
		int i = left, j = right;
		while (i <= j) {	
			while (array[i] < pivot) 
				i++;
			while (array[j] > pivot) 
				j--;
			if (i <= j) {
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				i++;
				j--;
			}
		}

		//Recursively sorts each subarray
		if (left < j)
			qSortOptimizedBubble(array, left, j);
		if (right > i)
			qSortOptimizedBubble(array, i, right);
	}
	
	
	private void insertionSort(int[] array, int left, int right){
		for (int i = left + 1; i < right; i++){
			int val = array[i];
			int j = i - 1;
			while (j >= 0 && val < array[j]){
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = val;
		}
	}
	
	//Simple Bubble sort 
	private static void bubbleSort( int [ ] array ){
		int i;
		boolean flag = true;  
		int temp;   
		while ( flag ){
			flag= false; 
			for( i =0;  i < array.length -1;  i++ ){
				if ( array[ i ] > array[i+1] ){
					temp = array[ i ];             
					array[ i ] = array[ i+1 ];
					array[ i+1 ] = temp;
					flag = true;           
				} 
			} 
		} 
	} 
	
	/* Randomly generates an array of integers 
	 * between 1-max, takes the size as its parameter
	 */
	public int [] randomArray( int size, int max){
		Random random = new Random();
		int[] randomArray = new int [size];
		for(int i = 0; i <randomArray.length; i++){ 
			randomArray[i] = random.nextInt(max)+1;
		}
		return randomArray;		
	}

	//Displays elements of the array
	void displayArray(int [] array){
		int columns = 0;
		for (int i = 0; i < array.length; i++){		
			if( columns <= 19){
				System.out.print(array[i] + ", ");
				columns++;
			}
			else if(columns > 19){
				System.out.print("\n" + array[i] + ", ");
				columns = 1;
			}
			
		}
		
	}

}
