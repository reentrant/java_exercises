package catchingAndThrowingExceptions;

public class ThrowingIllegalArgumentException {
	
	public static void main(String [] args){
		int a = 1;
		int b = 0;
		divideNumbers(a, b);
	}

	public static void divideNumbers(int dividend, int divisor){
		if (divisor == 0){
			throw new IllegalArgumentException("The divisor can not be 0");
		}
	}
}
