package QuickSort;

public class QuickSortAnalysis {

	public static void main(String[] args) {
		System.out.println("***********************************************************************************\n" +
				" QuicSortAnalysis.java\n" + 
				" CMIS 350 7980 Project 2\n" +
				" Purpose: This program measures the performance of quicksort and the two\n" +
				"          optimization  methods using various sizes." + 
				" Author Dakin T. Werneburg\n" +
				" Version 1.0 4/11/2015\n" +
				" *******************************************************************************************\n\n");
		
		
		
		System.out.println("------------------------------------------------------------------------------\n" + 
		                   "|                           Average execution time for 100 runs               |\n" +
				           "|-----------------------------------------------------------------------------|\n" +
		                   "|                 |     SIZE = 100     |    SIZE = 1,000   |  SIZE = 10,000   |\n" +
				           "|                 |     MAX  = 999     |    MAX  = 9,999   |  MAX  = 99,999   |\n" +
				           "|-----------------------------------------------------------------------------|");
		System.out.printf("| QuickSort       |%10s %8s |%10s %7s |%10s %6s |", quickSortPerformance(100,999) ,"", 
				quickSortPerformance(1000,9999), "", quickSortPerformance(10000,99999), "");
		System.out.println("\n-------------------------------------------------------------------------------");
		System.out.printf("| QSopt1          |%10s %8s |%10s %7s |%10s %9s", qsopt1Performance(100,999) ,"", 
				qsopt1Performance(1000,9999), "", qsopt1Performance(10000,99999), "|\n");
		System.out.println("-------------------------------------------------------------------------------");
		System.out.printf("| QSopt2          |%10s %8s |%10s %7s |%10s %8s", qsopt2Performance(100,999) ,"", 
				qsopt2Performance(1000,9999), "", qsopt2Performance(10000,99999), "|");
		System.out.println("\n-------------------------------------------------------------------------------");

	}
	
	public static long quickSortPerformance(int size, int max){
		QuickSortOptimization measure = new QuickSortOptimization();
		long [] arrayOfTimes = new long [100];
		long start, end, time;
		for(int i = 0; i < 100; i++){
			int [] array = measure.randomArray(size, max);
			start = System.nanoTime();
			measure.quickSort(array, 0, array.length-1);
			end = System.nanoTime();
			time = end - start;
			arrayOfTimes[i] = time;
		}
		long sum = 0;
		long average;
		for(int i = 5; i<arrayOfTimes.length; i++){
			sum += arrayOfTimes[i];
		}
		average = sum /arrayOfTimes.length -5 ;
		return average;
	}

	public static long qsopt1Performance(int size, int max){
		QuickSortOptimization measure = new QuickSortOptimization();
		long [] arrayOfTimes = new long [100];
		long start, end, time;
		for(int i = 0; i < 100; i++){
			int [] array = measure.randomArray(size, max);
			start = System.nanoTime();
			measure.qSortOptimizedInsertion(array, 0, array.length-1);
			end = System.nanoTime();
			time = end - start;
			arrayOfTimes[i] = time;			
		}
		long sum = 0;
		long average;
		for(int i = 5; i<arrayOfTimes.length; i++){
			sum += arrayOfTimes[i];
		}
		average = sum /(arrayOfTimes.length -5);
		return average;
	}	

	public static long qsopt2Performance(int size, int max){
		QuickSortOptimization measure = new QuickSortOptimization();
		long [] arrayOfTimes = new long [100];
		long start, end, time;
		for(int i = 0; i < 100; i++){
			int [] array = measure.randomArray(size, max);
			start = System.nanoTime();
			measure.qSortOptimizedBubble(array, 0, array.length-1);
			end = System.nanoTime();
			time = end - start;
			arrayOfTimes[i] = time;
		}
		long sum = 0;
		long average;
		for(int i = 5; i<arrayOfTimes.length; i++){
			sum += arrayOfTimes[i];
		}
		average = sum /arrayOfTimes.length -5;
		return average;
	}

}
