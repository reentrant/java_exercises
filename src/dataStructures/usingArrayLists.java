package dataStructures;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
	
public class usingArrayLists {

		public static void usingStringArrays() {

	    	
	    	
	    	List<String> myList = new ArrayList<String>();
		    myList.add("This");
		    myList.add("is");
		    myList.add("a");
		    myList.add("LIST");
		    myList.add("implemented");
		    myList.add("with");
		    myList.add("An");
		    myList.add("ArrayList");
		
		    System.out.println(myList);
		    
		    myList.sort(String::compareTo);
		    System.out.println(myList);
		    
		    myList.removeIf(x -> x.startsWith("T"));
		    
		    myList.removeIf(x -> x.toLowerCase().contains("i"));
		    System.out.println(myList);
		
		    myList.sort(String::compareToIgnoreCase);
		    System.out.println(myList);
		    
		    List<String> myList2 = new ArrayList<String>();
		    myList2.add("This");
		    myList2.add("is");
		    myList2.add("another");
		    myList2.add("LIST");
		    myList2.add("implemented");
		    myList2.add("with");
		    myList2.add("An");
		    myList2.add("ArrayList");

		    System.out.println(myList2);

		    System.out.println("Does List2 contain the whole myList? "+
			    	    myList2.containsAll(myList));

		    myList.retainAll(myList2);
		    System.out.println(myList);

		    System.out.println("Does List2 contain the whole myList? "+
			    	    myList2.containsAll(myList));
		
		    myList2.removeAll(myList);
		    System.out.println(myList2);
		    System.out.println("Does List2 contain the whole myList? "+
			            myList2.containsAll(myList));
		    

		}
		
		public static void usingIntArrays() {
	    	//		    More examples
		    ArrayList<Integer> arraylist1 = new ArrayList<Integer>();
		    ArrayList<Integer> arraylist2 = new ArrayList<Integer>();
		    ArrayList<Integer> arraylist3 = new ArrayList<Integer>();

		    for (int i = 0; i<5; i++){
		        arraylist1.add(i);
		        arraylist2.add(5-i-1);
		    }
		    arraylist1.addAll(2, arraylist2);
		    System.out.println(arraylist1.toString());
		    
		    arraylist1.addAll(6, arraylist1);
		    System.out.println(arraylist1.toString());
		    arraylist3.addAll(arraylist1.subList(4, 9));
		    System.out.println(arraylist3.toString());
		}
		
		
	
//	    private static void printList(List<String> mine){
//	        for(String s : mine)
//	            System.out.print(s+" ");
//	        System.out.println();
//	    }
//	    
//	    private static void printList(List<Integer> mine){
//	        for(Integer s : mine)
//	            System.out.print(s+" ");
//	        System.out.println();
//	    }
	    private static List<Integer> createRandomList(int size, int max){
	        List<Integer> result = new ArrayList<Integer>();
	        
	        for (int i=0; i< size; i++){
	            result.add( (int)( Math.random()*max));
	        }
	        return result;
	    } 
	    /*
	     * You should implement this function without resorting to use HashSet
	     * and maintaining the order of the List
	     */
	    private static void removeDuplicates(List<Integer> mine){
	    	int [] indexes = new int [5];

	    	Iterator <Integer> iterator = mine.iterator();
	    	while (iterator.hasNext()) {

	    		if (++indexes[iterator.next()] > 1)
	    			iterator.remove();
	    		
	    	}
	    }	    
	    public static void main(String args[]){
	        	List<Integer> myList = createRandomList(10,5);
	        	System.out.println(myList);
	    	    //remove Duplicates from myList
	    	    removeDuplicates(myList);
	    	    System.out.println(myList);
//	    	usingStringArrays();
//	    	usingIntArrays();



	    }
	}

