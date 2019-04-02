package stack_array_imp;

public class Stack<T> {

	private T[] stack;
	private int numberOfItems;

	public Stack() {
		this.stack = (T[]) new Object[1];
	}

	//O(1) if no resize
	public void push(T newData) {
		if (numberOfItems == stack.length) {
			resize(stack.length * 2);
		}

		stack[numberOfItems++] = newData;
	}
	
	//O(1) if no resize
	public T pop() {
		
		T itemToPop = null;
		
		if(numberOfItems > 0) {
			itemToPop = this.stack[--numberOfItems];
			this.stack[numberOfItems]=null;
			
			if((numberOfItems == this.stack.length / 4)) {
				resize(this.stack.length / 2);
			}
		}
		
		return itemToPop;
	}
	
	public T peek() {
		return this.stack[numberOfItems - 1];
	}
	
	public boolean isEmpty() {
		return numberOfItems == 0;
	}

	public int size() {
		return numberOfItems;
	}
	
	// O(N)
	private void resize(int capacity) {

		T[] stackToCopy = (T[]) new Object[capacity];
		for (int i = 0; i < numberOfItems; i++)
			stackToCopy[i] = this.stack[i];

		this.stack = stackToCopy;
	}
}
