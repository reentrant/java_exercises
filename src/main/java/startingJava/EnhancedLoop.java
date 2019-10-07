/**
 * 
 */
package startingJava;

/**
 *
 */
public class EnhancedLoop {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = new int[] {11, 22, 33, 44, 55};
		double average = 0, sum = 0;
		for (int element : array){
		    sum += element;
		}
		if (array.length > 0){
		    average = sum/ array.length;
		}
		System.out.println(average);

	}

}
