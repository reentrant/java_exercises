package catchingAndThrowingExceptions;

public class ExceptionsIndexOutOfBound {
	
	public static void main(String [] args){
		try {
			char[] anArray = new char[] { 'J', 'a', 'v', 'a' };
			char lastChar = anArray[-1];
			System.out.print(lastChar);
		} catch (ArrayIndexOutOfBoundsException e){
			System.out.println(e);
			System.out.println(e.getStackTrace());
		}
		finally {
			System.out.println("Inside the finally block");
		}
	}

}
