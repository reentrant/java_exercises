package catchingAndThrowingExceptions;

public class ExceptionsArithmetic {

	public static void main(String args[]){
		try{
			int result = 1 / 0;
			System.out.println(result);
		} catch (ArithmeticException e){
			System.out.println(e.toString());
			System.out.println(e.getStackTrace());
		}
		finally {
			System.out.println("Inside the finally block");
		}
	}
}
