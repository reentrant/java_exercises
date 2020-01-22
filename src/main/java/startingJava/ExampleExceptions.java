package startingJava;

public class ExampleExceptions {

	public static void main(String args[]) {
		int d = 0;
		int n = 20;
		try {
			int fraction = n / d;
			System.out.println("Line not executed: " + fraction);
		} catch (Exception e) {
			System.out.println("Generic Exception: " + e);
			System.out.println(e.getStackTrace());
		} finally {
			System.out.println("Inside the finally block");
		}
	}// main
}// class
