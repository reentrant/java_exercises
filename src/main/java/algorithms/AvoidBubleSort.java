package algorithms;

import java.util.Scanner;

public class AvoidBubleSort {
	
	public static void buble_sort(int [] array){
		int numSwaps = 0;
		int firstElement;
		int lastElement;
		for (int i = 0; i < array.length; i++){
			int numberOfTraversalSwaps = 0;
			for (int j = 0; j < array.length -1; j++){
				if (array[j] > array[j + 1]){
					int aux = array[j+1];
					array[j+1] = array[j];
					array[j] = aux;
					numSwaps++;
					numberOfTraversalSwaps++;
				}
			}
			if (numberOfTraversalSwaps == 0){
				break;
			}
		}
		System.out.println("Array is sorted in " + numSwaps + " swaps.");
		System.out.println("First Element: " + array[0]);
		System.out.println("Last Element: " + array[array.length -1]);
	}
	
	public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] array = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            array[a_i] = input.nextInt();
        }
        buble_sort(array);
	}
}
