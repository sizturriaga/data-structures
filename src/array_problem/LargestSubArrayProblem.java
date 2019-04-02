package array_problem;

public class LargestSubArrayProblem {

	public static void main(String[] args) {
		Integer[] array = new Integer[] {1,-2,3,4,-5,8,1,-2,3,4,-25,8,1,-2,3,4,-55,8,1,-2,-100,3,4,-5,8};
		largestSum(array);

	}
	
	//Kadane algorithms 
	private static void largestSum(Integer[] array) {
		
		int max_global = array[0];
		int max_current = array[0];
		
		for (int i = 1; i < array.length; i++) {
			
			max_current = Math.max(array[i], max_current + array[i]);
			
			System.out.println("max_current "+max_current+", max_global "+max_global+", index "+i);
			
			if(max_current > max_global)
				max_global = max_current;
			
			
			
		}
		
		//System.out.println("max_current "+max_current);
		System.out.println("max_global "+max_global);
	}
}


