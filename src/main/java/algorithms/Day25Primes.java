package algorithms;

import java.util.Scanner;

class Day25Primes {
	static boolean isPrime(int number){
		boolean result = false;
		
		if (number == 2){
			result = true;
		}else{
			if (number < 2 || number % 2 == 0){
				result = false;
			}else{
				if (Math.sqrt(number) % 1 == 0)
					return false;
				else{
					result = true;
					for (int i = 2; i < Math.sqrt(number); i++){
						if (number % i == 0){
							return false;
						}
					}
				}
			}
		}
		return result;
	}
	
	public static void main(String args[]){
        /* Enter your code here. 
         * Read input from STDIN. 
         * Print output to STDOUT. 
         */
		Scanner scanner = new Scanner(System.in);
		int trials = scanner.nextInt();
		for (int i = 0; i < trials; i++){
			int number = scanner.nextInt();
			if (number >=1 && number < 2 * Math.pow(10, 9))
				System.out.println(isPrime(number) ? "Prime" : "Not prime");
		}
    }
}
