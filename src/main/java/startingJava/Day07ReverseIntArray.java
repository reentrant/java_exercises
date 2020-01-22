package startingJava;

import java.util.Scanner;

public class Day07ReverseIntArray {
	private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arrayNumbers = new int[n];

        String[] arrayString = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrayString[i]);
            arrayNumbers[i] = arrItem;
        }
        // display in reverse order as they were entered:
        for (int i = 0; i < n; i++) {
        	System.out.print(arrayNumbers[n -1 -i] + " ");
        }

        scanner.close();
    }
}
