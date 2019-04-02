package binary_search_tree_imp;

public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {

	private Node<T> root;

	@Override
	public void insert(T data) {
		if (root == null) {
			root = new Node<T>(data);
		} else {
			insertNode(data, root);
		}
	}

	@Override
	public void traversal() {
		if (this.root != null) {
			inOrderTraversal(this.root);
		}
	}

	private void inOrderTraversal(Node<T> node) {

		if (node.getLeftChild() != null)
			inOrderTraversal(node.getLeftChild());

		System.out.print(node + " --> ");

		if (node.getRightChild() != null)
			inOrderTraversal(node.getRightChild());

	}

	private void insertNode(T newData, Node<T> node) {

		if (node.getData().compareTo(newData) > 0) {
			if (node.getLeftChild() != null) {
				insertNode(newData, node.getLeftChild());
			} else {
				node.setLeftChild(new Node<T>(newData));
			}
		} else {
			if (node.getRightChild() != null) {
				insertNode(newData, node.getRightChild());
			} else {
				node.setRightChild(new Node<T>(newData));
			}
		}
	}

	@Override
	public void delete(T data) {
		if (this.root != null) {
			root = delete(root, data);
		}
	}

	private Node<T> delete(Node<T> node, T data) {

		if (node == null)
			return node;

		if (data.compareTo(node.getData()) < 0) {
			node.setLeftChild(delete(node.getLeftChild(), data));
		} else if (data.compareTo(node.getData()) > 0) {
			node.setRightChild(delete(node.getRightChild(), data));
		} else {
			
			if(node.getLeftChild() == null && node.getRightChild() == null) {
				System.out.println("Removing a leaf node --> "+node);
				return null;
			}
			
			if(node.getLeftChild() == null) {
				System.out.println("Removing the right child --> "+node);
				Node<T> tempNode = node.getRightChild();
				node = null;
				return tempNode;
			}else if(node.getRightChild() == null) {
				System.out.println("Removing the left child --> "+node);
				Node<T> tempNode = node.getLeftChild();
				node = null;
				return tempNode;
			}
			
			System.out.println("Removing node with two children --> "+node);
			Node<T> tempNode = getPredecessor(node.getLeftChild());
			node.setData(tempNode.getData());
			node.setLeftChild(delete(node.getLeftChild(), tempNode.getData()));


		}

		return node;
	}

	private Node<T> getPredecessor(Node<T> node) {
		
		if(node.getRightChild() != null)
			return getPredecessor(node.getRightChild());
			
		System.out.println("Predecessor node --> "+node);
		return node;
	}

	@Override
	public T getMaxValue() {
		if (this.root == null)
			return null;

		return this.getMax(this.root);
	}

	private T getMax(Node<T> node) {
		if (node.getRightChild() != null) {
			return getMax(node.getRightChild());
		}

		return node.getData();
	}

	@Override
	public T getMinValue() {
		if (this.root == null)
			return null;

		return this.getMin(this.root);
	}

	private T getMin(Node<T> node) {

		if (node.getLeftChild() != null) {
			return getMin(node.getLeftChild());
		}

		return node.getData();
	}
	
	@Override
	public Node<T> getRoot() {
		return this.root;
	}
	
}
