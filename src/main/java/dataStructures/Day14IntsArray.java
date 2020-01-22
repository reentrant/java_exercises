package dataStructures;

import java.util.Scanner;

class Difference {
  	private int[] elements;
  	public int maximumDifference;

	// Add your code here
  	Difference(int [] array){
        this.elements = array;
    }
    
    public void computeDifference() {
        int [] counters = new int[100];
        int smallest = 200, biggest = 0;
        for (int e: elements) {
            counters[e] += 1;
            if (e > biggest) {
            	biggest = e;
            }
            if (e < smallest) {
            	smallest = e;
            }
        }
        
        maximumDifference = biggest - smallest; 
    }

} // End of Difference class

public class Day14IntsArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();

        Difference difference = new Difference(a);

        difference.computeDifference();

        System.out.print(difference.maximumDifference);
    }
}
