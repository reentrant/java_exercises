package startingOOP;

public class Swaper {
	
	

	public static void swap(Integer a, Integer b) {
		Integer aux = a;
		a = b;
		b = aux;
	}
	
	public static void main(String[] args) {
		Integer ref_first = new Integer(1);
		Integer ref_scnd = new Integer(2);
		System.out.println(ref_first.toString());
		System.out.println(ref_scnd.toString());
		swap(ref_first, ref_scnd);
		
		System.out.println(ref_first + " " + ref_scnd);
		

	}

}
