package dataStructures;
import java.util.ArrayList;
import java.util.Arrays;

public class BiDimentionalArrays {

	
	public static void main(String[] args) {
		int[][]array = {{16,3,2,13},{5,10,11,8},{9,6,7,12},{4,15,14,1}};
		method(array);
		ArrayList<Object> list = new ArrayList<Object>();
		list.add("a");
		list.add(1);
		list.add(4.0);
		Object value = list.get(0);
		System.out.println(list.toString());
	}

	private static void method(int[][] array) {
	    int [] var = new int[array[0].length];
	    for (int i = 0; i < array.length; i++){   
	        for (int j = 0; j < array[i].length; j++){                
	            var[j] += array[i][j];
	            System.out.print(var[j] + " ");
	        }
//	        Arrays.sort(var);
	        System.out.println("");
	        System.out.println(Arrays.toString(var));
	    }  
	}
}
