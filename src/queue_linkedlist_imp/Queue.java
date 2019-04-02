package queue_linkedlist_imp;

public class Queue<T extends Comparable<T>> {

	private Node<T> firstNode;
	private Node<T> lastNode;
	private int count;
	
	public boolean isEmpty() {
		return this.firstNode == null;
	}
	
	public int size() {
		return this.count;
	}
	
	//O(1)
	public void enqueue(T newData) {
		
		this.count++;
		Node<T> oldLastNode = this.lastNode;
		this.lastNode = new Node<T>(newData);
		
		if(this.isEmpty()) {
			this.firstNode = this.lastNode;
		}else {
			oldLastNode.setNextNode(this.lastNode);
		}
	}
	
	//O(1)
	public T dequeue() {
		
		if(!this.isEmpty()) {
			T dataToDequeue = this.firstNode.getData();
			this.firstNode = this.firstNode.getNextNode();
			this.count--;
			return dataToDequeue;
		}else {
			this.lastNode = null;
			return null;
		}
		
	}
}
