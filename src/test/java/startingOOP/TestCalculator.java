package startingOOP;

public class TestCalculator {

	int nonStaticProperty;
	CalculatorLibrary calc;
	
	public TestCalculator() {
		System.out.println("\nAPI Client class constructor\n");
		this.nonStaticProperty = -1;
		this.calc = new CalculatorLibrary();
	}
	
	public void usingObjectArgs(CalculatorLibrary obj){
		obj.substract();
		int a = 3;
		int b = 5;
		System.out.println("Adding some numbers: " + a + " + " + b + " = " + obj.add(a, b));
		obj.multiply();
	}

	public static void main(String[] args) {
		TestCalculator ourInstance = new TestCalculator();
		ourInstance.usingObjectArgs(ourInstance.calc);
	}

}
