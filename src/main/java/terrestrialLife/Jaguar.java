package terrestrialLife;

public class Jaguar extends Animal{

	public static void main(String[] args) {
		Jaguar j = new Jaguar();
		System.out.println(j.toString());
		if (j.isAlive()) {
			j.breathes();
		}

	}

	@Override
	public boolean isAquatic() {
		return false;
	}

	@Override
	public boolean isTerrestrial() {
		return true;
	}

	@Override
	public boolean isAlive() {
		System.out.println("I am alive!");
		return true;
	}

	@Override
	public void speaks() {
		System.out.println("Grr!");
	}

}
