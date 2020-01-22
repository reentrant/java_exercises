package startingOOP;

public class ExampleEncapsulation {
	public static void main(String[] args) {
		TimeStamp instance = new TimeStamp();
		System.out.println(instance.getClassCurrentTime());
		instance.setClassCurrentTime(1);
		System.out.println(instance.getClassCurrentTime());
	}
}

class TimeStamp {
	private long currentTimeMillis;

	public TimeStamp() {
		this.currentTimeMillis = System.currentTimeMillis();
	}

	public void setClassCurrentTime(long time) {
		this.currentTimeMillis = time;
	}

	public long getClassCurrentTime() {
		return this.currentTimeMillis;
	}
}
