package startingJava;
/*
 * Task
 * Given set S = {1, 2, 3, .., n}. Find two integers, a and b (where  a< b), from set S such that the value of a & b
 * is the maximum possible and also less than a given integer k.
 */
import java.util.Scanner;

public class Day29BitOperators {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nk = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nk[0]);

            int k = Integer.parseInt(nk[1]);
            System.out.println(solution(n, k));
        }

        scanner.close();
    }
    
    public static int solution(int n, int k){
    	int max = 0;
    	for (int i = 1; i < n; i ++){
    		for (int j = 2; j < n + 1; j++){
    			if (i < j && (i & j) < k){
    				if ((i & j) > max){
    					max = i & j;
    				}
    			}
    		}
    	}
    	return max;
    }

}
