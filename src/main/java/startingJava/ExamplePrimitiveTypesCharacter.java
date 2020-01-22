package startingJava;

public class ExamplePrimitiveTypesCharacter {

	public ExamplePrimitiveTypesCharacter() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		char c = '@';
		System.out.println("The char Type uses " + Character.SIZE + " bits");
		System.out.println("It means " + Character.BYTES + " bytes.");
		System.out.println("Example: ");

		for (int i = 33; i < 200; i++) {
			char letter = (char) i;
			System.out.println("Char: " + i + '\t' + Character.toString(letter));
		}
		

	}

}
