package startingOOP;

public class ConstructorExample {
	public int propertyA;
	public int propertyB;

	public ConstructorExample() {
		// Default Constructor witout arguments
		this.propertyA = 0;
		this.propertyB = 1;
	}
	
	public ConstructorExample(int a, int b) {
		this.propertyA = a;
		this.propertyB = b;
	}
	
	public static void main(String [] args){
		ConstructorExample myClass1 = new ConstructorExample();
		System.out.println(myClass1);
		System.out.println(myClass1.propertyA);
		System.out.println(myClass1.propertyB);
		System.out.println("===");
		ConstructorExample myClass2 = new ConstructorExample(5, 7);
		System.out.println(myClass2);
		System.out.println(myClass2.propertyA);
		System.out.println(myClass2.propertyB);
	}

}
