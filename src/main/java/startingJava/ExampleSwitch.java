package startingJava;

import java.util.Random;

public class ExampleSwitch {

	public ExampleSwitch() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		Random randomGenerator = new Random();
		int dice = 1 + randomGenerator.nextInt(6);
		switch (dice) {
		case 1:
			System.out.println(".");
			break;
		case 2:
			System.out.println("..");
			break;
		case 3:
			System.out.println("...");
			break;
		case 4:
			System.out.println("::");
			break;
		case 5:
			System.out.println(":.:");
			break;
		default:
			System.out.println(dice);
		}
	}

}
