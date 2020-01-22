/**
 * Example def power: x ^ y
 * precondition: y > 0
 * 	x ^ y = 1 				if (y == 0)
 * 	x ^ y = x * x ^ y-1 	if (y > 0)
 */

package startingJava;

public class ExampleRecursiveMethods {

	static long calculatePower(long x, int y) {
		long power = 0;
		if (y > 0) {
			power = x * calculatePower(x, y - 1);
		} else if (y == 0) {
			power = 1;
		}
		return power;
	}

	public static void main(String[] args) {
		System.out.println(calculatePower(2, 10));
		System.out.println(calculatePower(1000, 0));
	}

}
