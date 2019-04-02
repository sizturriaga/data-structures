package binary_search_tree_imp;

public class KthSmallestLargestItem<T extends Comparable<T>> {

	public T getKthSmallestLargestItem(Node<T> node, int k) {
	
		int n = lengthLeftSubTree(node.getLeftChild()) + 1;
		
		if(n == k) return node.getData();
		
		if(n > k) 
			return getKthSmallestLargestItem(node.getLeftChild(), k);
		else if(n < k) 
			return getKthSmallestLargestItem(node.getRightChild(), k-n);
		
		return null;
		
	}

	private Integer lengthLeftSubTree(Node<T> node) {

		if(node == null) return 0;
		
		return (lengthLeftSubTree(node.getLeftChild()) + lengthLeftSubTree(node.getRightChild())) + 1;
	}
	
	
}
