package algorithms;

class Solution {
	public static int minimum_index(int[] seq) {
        if (seq.length == 0) {
            throw new IllegalArgumentException("Cannot get the minimum value index from an empty sequence");
        }
        int min_idx = 0;
        for (int i = 1; i < seq.length; ++i) {
            if (seq[i] < seq[min_idx]) {
                min_idx = i;
            }
        }
        return min_idx;
    }
}

public class Day27FindTheMinIndex {
	
	public static void main(String [] args){
		int [] array = {10000, 1};
		int result = Solution.minimum_index(array);
		System.out.println(result);
		assert(result == 1);
	}
}