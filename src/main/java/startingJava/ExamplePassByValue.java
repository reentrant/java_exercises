package startingJava;

public class ExamplePassByValue {
	

	public static void passByValue(Integer a, Integer b) {
		System.out.print("Received values: ");
		System.out.println(a.toString() + " " + b.toString());
		Integer aux = a;
		a = b;
		b = aux;
	}
	
	public static void main(String[] args) {
		Integer first = new Integer(1);
		Integer second = new Integer(2);
		Integer ref_first = first;
		Integer ref_scnd = second;
		passByValue(ref_first, ref_scnd);
		System.out.print("The values are NOT swapped: ");
		System.out.println(ref_first.toString() + " " + ref_scnd.toString());
	}

}
