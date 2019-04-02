package array_problem;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DuplicateInteger {

	public static void main(String[] args) {
		
		Integer[] array = new Integer[] {4,3,1,2,3,2,2,4};
		
		long i = System.currentTimeMillis();
		findDuplicateInteger(array);
		long f = System.currentTimeMillis();
		long time = f - i;
		System.out.println("time "+ time);

	}

	private static void findDuplicateInteger(Integer[] array) {
		Map<Integer, Integer> values = new HashMap<>();
		Set<Integer> duplicated = new HashSet<>(array.length);
		
		for (int i = 0; i < array.length; i++) {
			if(values.get(array[i]) != null) {
				duplicated.add(array[i]);
			}else {
				values.put(array[i], i);
			}
		}
		
		duplicated.stream().forEach(f -> System.out.println("duplicated "+ f));
	}
	
	/**
	 * It only run if the mayor element is less than the array's length
	 * and there is not more than two duplicate elements
	 * @param array
	 */
	private static void findDuplicateInteger2(Integer[] array) {
		
		for (int i = 0; i < array.length; i++) {
				
			int item = array[Math.abs(array[i])];
			if( item > 0) {
				array[Math.abs(array[i])] = -item;
			}else {
				System.out.println("duplicated "+ Math.abs(array[i]));
			}
		}
	}
	

}
