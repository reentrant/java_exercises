package startingJava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day28Regex {
	private static final Scanner scanner = new Scanner(System.in);	
	
	public static void practiceRegex() {
		// This will match a sequence of 1 or more uppercase and lowercase English letters as well as spaces
		String myRegExString = "[a-zA-Z\\s]+";

		// This is the string we will check to see if our regex matches:
		String myString = "The quick brown fox jumped over the lazy dog...";

		// Create a Pattern object (compiled RegEx) and save it as 'p'
		Pattern p = Pattern.compile(myRegExString);

		// We need a Matcher to match our compiled RegEx to a String
		Matcher m = p.matcher(myString);

		// if our Matcher finds a match
		if( m.find() ) {
		    // Print the match
		    System.out.println( m.group() );
		}	
	}
	
	public static void main(String[] args) {
		int N = scanner.nextInt();
		Map<String, String> people = new HashMap<String, String>();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int NItr = 0; NItr < N; NItr++) {
            String[] firstNameEmailID = scanner.nextLine().split(" ");
            String firstName = firstNameEmailID[0];
            String emailID = firstNameEmailID[1];

            if (isGmailAccount(emailID)){
            	people.put(emailID, firstName);
            }
        }
//        TODO: Sort by value the map
        System.out.println(people.toString());
        List<String> valueList = new ArrayList<String>(people.values());
        Collections.sort(valueList);
        for(String person: valueList){
        	System.out.println(person);
        }
        scanner.close();
	}
	
	public static boolean isGmailAccount(String email){
		boolean result = false;
		Pattern p = Pattern.compile("@gmail.com");
		Matcher m = p.matcher(email);
		if (m.find()){
			result = true;
		}
		return result;
	}
	
	public static void sortMapByValue(Map<String, String> people){
		List<String> keyList = new LinkedList<String>(people.keySet());
		List<String> valueList = new ArrayList<String>(people.values());
		Collections.sort(valueList);
		System.out.println(valueList);
	}
}
