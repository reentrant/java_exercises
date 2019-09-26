package startingJava;
import java.util.Scanner;

public class Day11Arrays2D {
		private static final Scanner scanner = new Scanner(System.in);
		
		public static int solution(int[][] array){
			int max_sum = -64;
			int pattern =3;
			for (int i =0; i < 4; i++){
				for (int j=0; j < 4; j++){
					int sum = array[i][j] + array[i][j+1] + array[i][j+2] +
								array[i+1][j+1] +
								array[i+2][j] + array[i+2][j+1] + array[i+2][j+2];
					if (sum > max_sum){
						max_sum = sum;
					}
				}
			}
			
			return max_sum;
		}

	    public static void main(String[] args) {
	        int[][] arr = new int[6][6];

	        for (int i = 0; i < 6; i++) {
	            String[] arrRowItems = scanner.nextLine().split(" ");
	            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	            for (int j = 0; j < 6; j++) {
	                int arrItem = Integer.parseInt(arrRowItems[j]);
	                arr[i][j] = arrItem;
	            }
	        }
	        long t = System.currentTimeMillis();
	        System.out.println(solution(arr));
	        t = System.currentTimeMillis() - t;
	        System.out.println("Solution takes: " + t + "ms");
	        scanner.close();
	    }

}
