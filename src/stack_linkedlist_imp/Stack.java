package stack_linkedlist_imp;

import linkedlist_problem.Node;

public class Stack<T extends Comparable<T>> {
	
	private Node<T> root;
	private int count;
	
	//O(1)
	public void push(T newData) {
		
		this.count++;
		
		if(this.root == null) {
			root = new Node<T>(newData);
		}else {
			Node<T> oldRoot = root;
			root = new Node<T>(newData);
			root.setNextNode(oldRoot);
		}
	}
	
	//O(1)
	public int size() {
		return this.count;
	}
	
	//O(1)
	public boolean isEmpty() {
		return (this.root == null);
	}
	
	//O(1)
	public T pop() {
		
		if(this.root == null) {
			return null;
		}
		
		T itemToPop = this.root.getData();
		this.root = this.root.getNextNode();
		this.count--;
		
		return itemToPop;
	}
	
	//O(1)
	public T peek() {
		return this.root.getData();
	}
}
