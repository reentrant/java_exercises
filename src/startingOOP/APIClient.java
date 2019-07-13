package startingOOP;

public class APIClient {

	int nonStaticProperty;
	CalculatorLibrary calc;
	
	public APIClient() {
		System.out.println("\nAPI Client class constructor\n");
		this.nonStaticProperty = -1;
		this.calc = new CalculatorLibrary();
	}
	
	public void usingObjectArgs(CalculatorLibrary obj){
		obj.substract();
		obj.add();
		obj.multiply();
	}

	public static void main(String[] args) {
		APIClient ourInstance = new APIClient();
		ourInstance.usingObjectArgs(ourInstance.calc);
	}

}
