package dataStructures;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class usingSets {
	
	public static void main(String [] args){
		Set<Integer> diceSet = new HashSet<Integer>();
		int[] array = new int[25];
		 for (int i =0; i < array.length; i++){
			 array[i] = (int) (1 + 6 * Math.random());
		 }
		 System.out.println(Arrays.toString(array));
		 for (Integer i: array){
//			 if (diceSet.contains(i) == false){
//				 diceSet.add(i);
//			 }
			 diceSet.add(i);
		 }
		 System.out.println(diceSet);

	}
}
