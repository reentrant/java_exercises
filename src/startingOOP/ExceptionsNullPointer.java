package startingOOP;

public class ExceptionsNullPointer {

	public static void main(String[] args) {

		int [] array = null;
		displayArray(array);

	}

	public static void displayArray(int[] array)
	{
		try {
			System.out.print(array.length);
		} catch (NullPointerException e){
			System.out.println(e.toString());
			System.out.println(e.getStackTrace());
		}
		finally {
			System.out.println("Inside the finally block");
		}
	}
	
}
