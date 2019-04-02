package queue_stack_backed_problem;

import java.util.Stack;

public class Queue<T extends Comparable<T>> {
	private Stack<T> enqueueStack;
	private Stack<T> dequeueStack;
	
	Queue(){
		this.enqueueStack = new Stack<T>();
		this.dequeueStack = new Stack<T>();
	}
	
	public void enqueue(T newData) {
		this.enqueueStack.push(newData);
	}
	
	public T dequeue() {
		if(enqueueStack.isEmpty() && dequeueStack.isEmpty()) {
			throw new RuntimeException("Stacks are empty...");
		}
		
		if(dequeueStack.isEmpty()) {
			while (!enqueueStack.isEmpty()) {
				dequeueStack.push(enqueueStack.pop());
			}
		}
		
		return dequeueStack.pop();
	}
	
}
