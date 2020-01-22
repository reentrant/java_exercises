
public class Average {

	public Average() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		double cumulativeTotal = 0.0;
		int n = 0;
		while (!StdIn.isEmpty()) {
			double x = StdIn.readDouble();
			cumulativeTotal = cumulativeTotal + x;
			n++;
		}
		StdOut.println(cumulativeTotal / n);
	}
}
