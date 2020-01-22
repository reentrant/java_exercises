package startingJava;

public class ExamplePrimitiveTypesIntegers {

	public ExamplePrimitiveTypesIntegers() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		byte bMin = Byte.MIN_VALUE;
		byte bMax = Byte.MAX_VALUE;
		byte b = 127;
		System.out.println("The Byte Type uses " + Byte.SIZE + " bits");
		System.out.println("From " + bMin + " to " + bMax);
		System.out.println("Example: " + b);
		
		long lMin = Long.MIN_VALUE;
		long lMax = Long.MAX_VALUE;
		long lValue = 1L + Integer.MAX_VALUE;
		System.out.println("The Long Type uses " + Long.SIZE + " bits");
		System.out.println("From " + lMin + " to " + lMax);
		System.out.println("Example: " + lValue);
	}

}
