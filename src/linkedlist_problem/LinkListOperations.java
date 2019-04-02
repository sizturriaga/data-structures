package linkedlist_problem;

public class LinkListOperations {

	public static void main(String[] args) {
		List<Integer> myLinkedList = new LinkedList<>();
		myLinkedList.insert(10);
		myLinkedList.insert(2);
		myLinkedList.insert(13);
		myLinkedList.insert(22);
		myLinkedList.insert(19);
		myLinkedList.insert(5);
		myLinkedList.insert(1);
		myLinkedList.insert(8);
		myLinkedList.insert(34);
		
		System.out.println("The middle point: "+myLinkedList.getMiddleNode());
		myLinkedList.traverseList();
		myLinkedList.reverse();
		System.out.println();
		myLinkedList.traverseList();
		myLinkedList.remove(13);
		System.out.println();
		myLinkedList.traverseList();
	}
}





