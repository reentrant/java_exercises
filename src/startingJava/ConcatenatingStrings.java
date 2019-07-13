package startingJava;

public class ConcatenatingStrings {
	public static void main(String[] args){
		String str1 = "Rock";
		String str2 = "Star";
		//Method 1 : Using concat
		String str3 = str1.concat(str2);
		System.out.println(str3);
		//Method 2 : Using "+" operator
		String str4 = str1 + str2;
		System.out.println(str4);

		System.out.println("==============");
		System.out.println("String methods");
		System.out.println("==============");

		String str_Sample = "RockStar";
		  //Length of a String
		  System.out.println("length(): " + str_Sample.length());
		
		//Compare to a String
		System.out.println("Compare To 'ROCKSTAR': " + str_Sample.compareTo("ROCKSTAR"));
		  //Compare to - Ignore case
		  System.out.println(".compareToIgnoreCase(\"ROCKSTAR\"): " + str_Sample.compareToIgnoreCase("ROCKSTAR"));
		
		//Check if String contains a sequence
		  System.out.println("Contains sequence 'tar': " + str_Sample.contains("tar"));
		  
		//Check if ends with a particular sequence
		  System.out.println("EndsWith characters 'ar': " + str_Sample.endsWith("ar"));
		  
		//Replace Rock with the word Duke
		  System.out.println("Replace 'Rock' with 'Duke': " + str_Sample.replace("Rock", "Duke"));
		  
		//Convert to LowerCase
		  System.out.println("Convert to LowerCase: " + str_Sample.toLowerCase());
		//Convert to UpperCase
		System.out.println("Convert to UpperCase: " + str_Sample.toUpperCase());
//		str_Sample[0] = 'P';
		
		System.out.println("Testing inmutability: " + str_Sample.getClass());
		//declare the String as an object S1 S2
        String S1 = "Hello Java String Method";
        String S2 = "RockStar";

        str_Sample = "This is Index of Example";
        //Character at position
        System.out.println("charAt(5): " + str_Sample.charAt(5));
      	//Index of a given character
      	System.out.println("Index of character 'S': " + str_Sample.indexOf('S'));
        System.out.println("Index of character 'x': " + str_Sample.indexOf('x'));
        //Character at position after given index value
        System.out.println("Index of character 's' after 3 index: " + str_Sample.indexOf('s', 4));
        //Give index position for the given substring
        System.out.println("Index of substring 'is': " + str_Sample.indexOf("is"));
        //Give index position for the given substring and start index
        System.out.println("Index of substring 'is' from index:" + str_Sample.indexOf("is", 3));
        
        try {
        	String s1 = "This is String CharAt Method";
	        //returns the char value at the 0 index
	        System.out.println("Character at 0 position is: " + s1.charAt(0));
	        System.out.println("Character at -1 position is: " + s1.charAt(-1));
        }
        catch (StringIndexOutOfBoundsException e) {
        	System.out.println(e.getStackTrace());
        }
	}
}
