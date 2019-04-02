package stack_maxitem_problem;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MaxItemProblem {

	public static void main(String[] args) {
		
		List<Integer> numbers = new ArrayList<>();
		numbers.add(1);
		numbers.add(23);
		numbers.add(37);
		numbers.add(10);
		
		Integer max = Integer.MIN_VALUE;
		Stack<Integer> stack = new Stack<>();
		
		for (Integer integer : numbers) {
			stack.push(integer);
			max = Math.max(integer, max);
		}
		
		System.out.println(max);
		
	}

}
