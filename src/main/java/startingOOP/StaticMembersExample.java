package startingOOP;

public class StaticMembersExample {
	int nonStaticProperty = 10;
	static int staticProperty = 0;

	public StaticMembersExample() {
		this.nonStaticProperty = 100;
	}
	
	public void nonStaticMethod(){
		System.out.println("Calling the nonStaticMethod()");
	}
	
	public static void staticMethod(){
		System.out.println("Calling the staticMethod()");
//		System.out.println("Calling the staticMethod()" + nonStaticProperty);
//		Exception in thread "main" Calling the nonStaticMethod()
//		java.lang.Error: Unresolved compilation problem: 
//			Cannot make a static reference to the non-static field nonStaticProperty
		System.out.println("Calling the staticMethod()" + staticProperty);
	}

	public static void main(String[] args) {
//		System.out.println(nonStaticProperty);		// Unresolved compilation problem: 
//		Cannot make a static reference to the non-static field nonStaticProperty
		StaticMembersExample anInstance = new StaticMembersExample();
		System.out.println(anInstance.nonStaticProperty);

		System.out.println(StaticMembersExample.staticProperty);
		
		
//		nonStaticMethod(); 							// Unresolved compilation problem: 
//		Cannot make a static reference to the non-static method nonStaticMethod() from the type StaticMembersExample
		anInstance.nonStaticMethod();
		StaticMembersExample.staticMethod();
	}

}
