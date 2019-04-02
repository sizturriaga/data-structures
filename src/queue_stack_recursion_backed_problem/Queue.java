package queue_stack_recursion_backed_problem;

import java.util.Stack;

public class Queue<T> {
	
	Stack<T> stack;
	
	Queue(){
		this.stack = new Stack<T>();
	}
	
	// 0(1)
	public void enqueue(T newData) {
		this.stack.push(newData);
	}
	
	//Here is used 2 stack but instead of explicitly define the second stack, 
	//it is used the call stack of the program (stack memory) 
	public T dequeue() {
		
		//base case
		if(this.stack.size() == 1)
			return this.stack.pop();
		
		T currentItem = this.stack.pop();
		T firstElement = this.dequeue();
		this.enqueue(currentItem);
		
		return firstElement;
		
	}

}
