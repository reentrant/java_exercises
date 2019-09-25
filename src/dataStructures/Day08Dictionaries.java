package dataStructures;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Day08Dictionaries {
	public static void main(String []args){
		Map<String, Integer> phoneBook = new HashMap<String, Integer>();
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for(int i = 0; i < n; i++){
            String name = input.next();
            int phone = input.nextInt();
            // Write code here
            if (!phoneBook.containsKey(name)) {
            	phoneBook.put(name, phone);
            }
        }
        while(input.hasNext()){
            String query = input.next();
            // Write code here
            if (phoneBook.containsKey(query)) {
            	System.out.println(query + "=" + phoneBook.get(query));	
            }else {
            	System.out.println("Not found");
            }
            
        }
        input.close();
    }
}
