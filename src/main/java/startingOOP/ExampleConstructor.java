package startingOOP;

public class ExampleConstructor {
	// class members:
	public int propertyA;
	public int propertyB;

	public ExampleConstructor() {
		// Default Constructor without arguments
		this.propertyA = 0;
		this.propertyB = 1;
	}
	
	public ExampleConstructor(int a, int b) {
		this.propertyA = a;
		this.propertyB = b;
	}
	
	public static void main(String [] args){
		ExampleConstructor myClass1 = new ExampleConstructor();
		System.out.println(myClass1);
		System.out.println(myClass1.propertyA);
		System.out.println(myClass1.propertyB);
		System.out.println("===");
		ExampleConstructor myClass2 = new ExampleConstructor(5, 7);
		System.out.println(myClass2);
		System.out.println(myClass2.propertyA);
		System.out.println(myClass2.propertyB);
	}

}
