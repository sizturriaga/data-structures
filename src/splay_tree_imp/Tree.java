package splay_tree_imp;

public interface Tree<T extends Comparable<T>> {

    void insert(T data);
    Node<T> find(T data);
    Node<T> getMin();
    Node<T> getMax();
    void inOrderTraversal();
    void printRoot();

}
