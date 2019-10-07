package startingJava;

import java.util.Random;

public class Conditionals {

	public Conditionals() {
		// TODO Auto-generated constructor stub
	}
	
	public static void comparingString(String s1, String s2){
		int result = s1.compareTo(s2);
      System.out.print("Which means: ");
      if (result < 0) { System.out.println("\"" + s1 + "\"" + " is lexicographically higher than " + "\"" + s2 + "\"");
      } else if (result == 0) {
          System.out.println("\"" + s1 + "\"" + " is lexicographically  equal to " + "\"" + s2 + "\"");
      } else if (result > 0) {
          System.out.println("\"" + s1 + "\"" + " is lexicographically less than " + "\"" + s2 + "\"");
      }

	}

	public static void main(String[] args) {
		
		
        System.out.println("Compare To 'a' b is : " + "a".compareTo("b"));
        comparingString("a", "b");

        System.out.println("Compare To 'b' a is : " + "b".compareTo("a"));
        comparingString("b", "a");

        System.out.println("Compare To 'b' b is : " + "b".compareTo("b"));
        comparingString("b", "b");
        System.out.println();
		Random randomGenerator = new Random();
		int dice = 1 + randomGenerator.nextInt(6);
		switch(dice){
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
