package binary_search_tree_imp;

public interface Tree<T> {

	public void traversal();
	public void insert(T data);
	public void delete(T data);
	public T getMaxValue();
	public T getMinValue();
	public Node<T> getRoot();
	
	
}
