package startingJava;

public class ExamplePrecedence {

	public ExamplePrecedence() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int a = 2;
		int b = 3;
		int res = -3 + 6 / ++a * 4 - b-- + b;
		int [] results = {
				-3,
				-3 + 6 / 3 * 4,
				-3 + 6 / 3 * 4 -3,
				-3 + 6 / 3 * 4 -3 + 2,
				};
		for (int result: results)
			System.out.println(result);
		System.out.println(res);
	}

}
