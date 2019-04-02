package linkedlist_problem;

public class LinkedList<T extends Comparable<T>> implements List<T>{
	
	private Node<T> head;
	private int sizeCounter;

	@Override
	public Node<T> getMiddleNode() {
		
		Node<T> fastPointer = this.head;
		Node<T> slowPointer = this.head;
		
		while (fastPointer.getNextNode()!= null && fastPointer.getNextNode().getNextNode()!= null) {
			fastPointer = fastPointer.getNextNode().getNextNode();
			slowPointer = slowPointer.getNextNode();
		}
		
		return slowPointer;
	}

	@Override
	public void insert(T data) {
		++sizeCounter;
		
		if(head == null) {
			head = new Node<>(data);
		}else {
			//insertDataBeginning(data);
			insertDataEnd(data);
		}
	}
	
	private void insertDataBeginning(T data) {
		Node<T> nextNode = new Node<>(data);
		nextNode.setNextNode(head);
		head = nextNode;
	}
	
	private void insertDataEnd(T data) {
		Node<T> node = new Node<>(data);
		Node<T> lastNode = getLastNode(head);
		lastNode.setNextNode(node);
	}
	

	@Override
	public void reverse() {
		Node<T> previousNode = null;
		Node<T> currentNode = this.head;
		Node<T> nextNode = null;
		
		while (currentNode != null) {
			nextNode = currentNode.getNextNode();
			currentNode.setNextNode(previousNode);
			previousNode = currentNode;
			currentNode = nextNode;
		}
		
		this.head = previousNode;
		
	}
	
	private Node<T> getLastNode(Node<T> head) {
		
		if(head.getNextNode() == null)
			return head;
		
		return getLastNode(head.getNextNode());
	}

	@Override
	public void remove(T data) {
		
		
		if(head.getData().equals(data)) {
			head = head.getNextNode();
			return;
		}else {
			Node<T> previousNode = head;
			Node<T> currentNode = head.getNextNode();
			
			while (currentNode != null) {
				if(currentNode.getData().equals(data)) {
					previousNode.setNextNode(currentNode.getNextNode());
					return;
				}
				previousNode = currentNode;
				currentNode = currentNode.getNextNode();
			}
		}
	}

	@Override
	public void traverseList() {
		Node<T> copyHead = this.head;
		while (copyHead != null) {
			System.out.print(copyHead.toString()+" ");
			copyHead = copyHead.getNextNode();
		}
	}

	@Override
	public int size() {
		return this.sizeCounter;
	}
	
}