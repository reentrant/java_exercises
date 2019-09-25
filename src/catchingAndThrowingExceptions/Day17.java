package catchingAndThrowingExceptions;

import java.util.Scanner;


class Calculator{
	Calculator(){
		
	}
	
	public int power(int n, int p) throws Exception{
		if (n >= 0 && p >= 0) {
			return (int) Math.pow(n, p);
		}
		else {
			throw new Exception("n and p should be non-negative");
		}
	}
}


class Day17{

    public static void main(String[] args) {
    
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while (t-- > 0) {
        
            int n = input.nextInt();
            int p = input.nextInt();
            Calculator myCalculator = new Calculator();
            try {
                int result = myCalculator.power(n, p);
                System.out.println(result);
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        input.close();
    }
}