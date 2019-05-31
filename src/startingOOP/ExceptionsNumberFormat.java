package startingOOP;

public class ExceptionsNumberFormat {
	
	public static void main(String [] args){
		try {
			System.out.println(Integer.parseInt("1000"));
			System.out.println(Integer.parseInt("12000 / 12"));
		} catch (NumberFormatException e){
			System.out.println(e);
			System.out.println(e.getStackTrace());
		}
		finally {
			System.out.println("Inside the finally block");
		}
	}

}
