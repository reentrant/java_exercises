package startingOOP;
/**
 * 
 *
 */
public class CalculatorLibrary {

	int aVariable = 5;
	/**
	 * 
	 */
	public CalculatorLibrary() {
		System.out.print("Calling the Calculator constructor\t");
	}

	/**
	 * @param args
	 */
	public void add(){
		System.out.println("Adding some numbers");
	}
	
	public void substract()
	{
		System.out.println("Substracting some numbers");
	}
	
	public void multiply()
	{
		System.out.println("Multiplying some numbers");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "Hello World, this is a Core Java course";
		System.out.println(str);
		System.out.println(new CalculatorLibrary());
		CalculatorLibrary calc = new CalculatorLibrary();
		System.out.println(calc);
		calc.substract();
	}

}
