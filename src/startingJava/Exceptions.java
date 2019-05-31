package startingJava;

public class Exceptions {

	public static void main(String args[]) {
		int d = 0;
		int n = 20;
		try {
			int fraction = n / d;
			System.out.println(fraction);
		} catch (Exception e) {
			System.out.println("In the catch Block due to Exception = " + e);
			System.out.println(e.getStackTrace());
		} finally {
			System.out.println("Inside the finally block");
		}
	}// main
}// class
