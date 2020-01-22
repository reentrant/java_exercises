package algorithms;

import java.util.Scanner;

class Zfunction{
	/**
	 * the function Z. https://www.codechef.com/problems/FCTRL For any positive
	 * integer N, Z(N) is the number of zeros at the end of the decimal form of
	 * number N!. They noticed that this function never decreases. If we have
	 * two numbers N1<N2, then Z(N1) <= Z(N2). It is because we can never "lose"
	 * any trailing zero by multiplying by any positive number. We can only get
	 * new and new zeros. The function Z is very interesting, so we need a
	 * computer program that can find the number of times 10 is a factor.
	 * 
	 */
	public Zfunction() {
		// TODO Auto-generated constructor stub
	}

	long factorial(long num) {
		if (num < 2 && num > 0)
			return 1;
		long result = num * factorial(num - 1);
		System.out.print(result + "\t");
		return result;
	}

	long zFunction(long number) {
		long factors = number / 5;
		long total = factors;
		for (int i = 2; factors > 1; i++) {
			factors = number /(long) Math.pow(5, i);
			total += factors;
		}
		return total;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Zfunction f = new Zfunction();
		int t = 0;
		long number;
		try{
			if(s.hasNextInt()) {
				t = s.nextInt();
				s.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
			}
			
			for (int i = 0; i < t && s.hasNextInt(); i++) {
				number = s.nextLong();
				System.out.println(f.zFunction(number));
			}	
		}
		catch(Exception e) {
			System.out.println(e) ;
		    System.out.println(e.getStackTrace());
		}
		finally{
			System.out.flush();
			s.close();	
		}
	}
}
