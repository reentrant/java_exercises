package startingJava;

public class ExamplePrimitiveTypesFloat {

	public ExamplePrimitiveTypesFloat() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		float fMin = Float.MIN_VALUE;
		float fMax = Float.MAX_VALUE;
		float f = 0.0F;
		System.out.println("The float Type uses " + Float.SIZE + " bits");
		System.out.println("From " + fMin + " to " + fMax);
		System.out.println("Example: " + f);
		
		double d = 0.0;
		
		System.out.println("The double Type uses " + Double.SIZE + " bits");
		System.out.println("Example: " + d);
	}

}
