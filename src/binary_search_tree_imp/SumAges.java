package binary_search_tree_imp;

public class SumAges<T> {
	
	public int getSumAges(Node<T> root) {
		
		if(root != null)
			return ((Person) root.getData()).getAge() + (getSumAges(root.getLeftChild()) +getSumAges(root.getRightChild()));
		
		return 0;
		
	}

}
