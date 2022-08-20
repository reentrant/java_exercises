package dataStructures;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map.Entry;

public class Dictionaries {
	public static void main(String[] args) {
        // De esta forma creo mi diccionario en java
        Hashtable<String, Integer> people = new Hashtable<String, Integer>();
 
        // De esta forma asocio a una persona con su edad en el diccionario
        people.put("Juan", 25);
        people.put("Roberto", 12);
        people.put("Pedro", 29);
        System.out.println(people.elements().toString());
        for (Entry<String, Integer> entry : people.entrySet()) {
        	  System.out.println(entry.getKey() + " tiene " + entry.getValue() + " years");
        	}
        
        
        List<String> list1 = new ArrayList<String>();
        for (String s: people.keySet()){
        	//System.out.println(s);
        	list1.add(s);
        }
        System.out.println(list1);
        	
    }
}
