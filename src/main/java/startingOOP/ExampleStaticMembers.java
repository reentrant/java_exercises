package startingOOP;

public class ExampleStaticMembers {
	static int staticProperty = 1000;
	int nonStaticProperty;

	public ExampleStaticMembers() {
		this.nonStaticProperty = 100;
	}
	
	public static void staticMethod(){
		System.out.println("Calling the staticMethod(), class member: " + staticProperty);
//		System.out.println(nonStaticProperty);		// Unresolved compilation problem: 
//		Cannot make a static reference to the non-static field nonStaticProperty

//		nonStaticMethod(); 							// Unresolved compilation problem: 
//		Cannot make a static reference to the non-static method nonStaticMethod() from the type StaticMembersExample
	}

	public static void main(String[] args) {
		staticMethod();
		ExampleStaticMembers anInstance = new ExampleStaticMembers();
		anInstance.nonStaticMethod();
	}
	
	public void nonStaticMethod(){
		System.out.print("Calling the nonStaticMethod(), class attribute: " + staticProperty);
		System.out.println(", instance variable: " + this.nonStaticProperty);
	}
}
