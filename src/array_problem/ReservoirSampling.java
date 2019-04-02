package array_problem;

import java.util.Random;

public class ReservoirSampling {

	public static void main(String[] args) {
		Integer[] array = new Integer[] {13,65,46,11,71,50,12,5,81,97,28,74,87,68,42,31,40,37,43,25};
		solver(array, 5);

	}
	
	private static void solver(Integer[] nums, int k) {
		int[] reservoir = new int[k];
		
		for (int i = 0; i < reservoir.length; i++) {
			reservoir[i] = nums[i];
		}
		
		for (int i = k+1; i < nums.length; i++) {
			int j = new Random().nextInt(i)+1;
			if(j < k) reservoir[j] = nums[i];
		}
		
		for (int i = 0; i < reservoir.length; i++) {
			System.out.print(""+reservoir[i]+" ");
		}
		
	}
}


