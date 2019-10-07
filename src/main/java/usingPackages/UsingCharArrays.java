package usingPackages;
import java.util.Arrays;

public class UsingCharArrays {

	public static void main(String [] args) {
		char[] data = {'a', 'b', 'c'};
		char[] array = {'j','a','v','a'};
		System.out.println(Arrays.toString(data) + data.toString());
		System.out.println(Arrays.toString(array) + array.toString());
		System.out.print(data.length + ": "); // length property
		
		compareEquivalentStrings(data);
		compareIdenticalStrings();
		swapingArrays(data, array);
		System.out.println(Arrays.toString(data) + data.toString());
		System.out.println(Arrays.toString(array) + array.toString());
		
	}
	
	public static void compareEquivalentStrings(char [] data) {
		String a = new String(data);
		System.out.print(a + " ");
		String b = new String("abc");
		if (a == b)
			System.out.println(a.compareTo(b));
		else{
			System.out.print((a == b) + " ");
			System.out.println(a.equals(b));
			System.out.println(a.compareTo(b));
		}
	}
	
	public static String compareIdenticalStrings() {
		String name1 = "Marisa";
		String name2 = "Marisa";
		if (name1 == name2) // object name1 is an alias to object name2
		{
			System.out.println(name1.equals(name2));
			System.out.print(name1.length() + ": "); // method length()
			for (char c: "Avril".toCharArray()) {
				System.out.print(c + " ");
			}
		}
		else {
			System.out.println(name1 == name2);
		}
		System.out.println("");
		return name1;
	}
	
	/**
	 * Java copies and passes the reference by value, not the object.
	 * Thus, method manipulation will alter the objects, since the references point to the original
	 * objects. But since the references are copies, swaps will fail
	 * 
	 * @param one
	 * @param two
	 */
	public static void swapingArrays(char [] one, char [] two) {
		one[0] = 'A';
		two[0] = 'J';
		char [] aux = one;
		one = two;
		two = aux;
	}
}

	