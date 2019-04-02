package binary_search_tree_imp;

public class TreeCompareHelper<T extends Comparable<T>> {

	public boolean compareTree(Node<T> node1, Node<T> node2) {
		
		System.out.println("node1: "+node1+" - node2: "+node2);
		
		//base case 
		if(node1 == null || node2 == null) return node1 == node2;
		
		//check the value of the nodes
		if(node1.getData().compareTo(node2.getData()) != 0) return false;
		
		//check the topology
		return (compareTree(node1.getLeftChild(), node2.getLeftChild()) && compareTree(node1.getRightChild(), node2.getRightChild()));
				
	}
}
