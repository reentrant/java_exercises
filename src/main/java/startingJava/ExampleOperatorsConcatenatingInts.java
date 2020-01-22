/**
 * The + operator for numbers represents addition, and for strings, concatenation.
 * If one operand is a number and one a string, the number gets converted to a string.
 * 
 */
package startingJava;

/**
 * Topic: Types, names, Strings
 *
 */
public class ExampleOperatorsConcatenatingInts {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a = 2;
		String b = "2";
		String z = a + b;
		System.out.println(z);
		operations();
	}

	public static void operations()
	{
		int a = 0;
		int b = a + 1;
		int c = (2*3) + 5 * 4;
		System.out.println("----Initial Values----------");
		System.out.println("a: " + a);
		System.out.println("b: " + b);
		System.out.println("c: " + c);
		int d = c++;
		System.out.println("d: " + d);
		System.out.println("c: " + c);
		int f = --c;
		System.out.println("f: " + f);
		System.out.println("c: " + c);
		System.out.println("----------------------------");
		System.out.println("d: " + d);
		System.out.println("d+1 :" + d + 1);
		System.out.println("c % 2: " + c % 2);
		System.out.println("f*2: " + f * 2);
		System.out.println("3+4+f*2: " + 3 + 4+ f*2);
	}
}
