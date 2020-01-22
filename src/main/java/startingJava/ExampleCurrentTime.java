package startingJava;

public class ExampleCurrentTime {

	public ExampleCurrentTime() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		long currentTimeMillis = System.currentTimeMillis();
		System.out.println(currentTimeMillis);
		long totalSeconds = currentTimeMillis / 1000;
		long seconds = totalSeconds % 60;
		long totalMinutes = totalSeconds / 60;
		long minutes = totalMinutes % 60;
		long totalHours = totalMinutes / 60;
		long hours = totalHours % 24;
		System.out.println("GMT time: " + hours + ":" + minutes + ":" + seconds);
	}

}
