package algorithms;

public class Sqrt {

	public static void main(String[] args) {
		double epsilon = 1e-15;
		double x = Double.parseDouble(args[0]);
		double squareRoot = x;
		while (Math.abs(squareRoot - x / squareRoot) > epsilon * squareRoot) {
			// Calculate average:
			squareRoot = (x / squareRoot + squareRoot) / 2.0;
			System.out.println(squareRoot);
		}
	}
}
