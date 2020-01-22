package startingOOP;

public abstract class ExampleAbstractAnimal implements ExampleBeingInteface{
	
	public void breathes() {
		System.out.println("This instance is breating: In ... Out...");
	}
	
	public abstract void speaks();

	public static void main(String[] args) {
		System.out.println("Invoking an abstract class");
	}

}
