package avl_tree_imp;

public class AvlTree<T extends Comparable<T>> implements Tree<T> {

    private Node<T> root;

    @Override
    public void insert(T data) {
        root = insert(root, data);
    }

    private Node<T> insert(Node<T> node, T data) {

        if(node == null) return new Node<>(data);

        if (data.compareTo(node.getData()) < 0) {
            node.setLeftNode(insert(node.getLeftNode(), data));
        } else {
            node.setRightNode(insert(node.getRightNode(), data));
        }

        node.setHeight(Math.max(height(node.getLeftNode()), height(node.getRightNode())) + 1);

        node = settleViolation(node, data);

        return node;
    }

    private Node<T> settleViolation(Node<T> node, T data) {

        int balance = getBalance(node);

        //case I left-left
        if(balance > 1 && data.compareTo(node.getLeftNode().getData()) < 0)
            return rightRotation(node);

        //case II right-right
        if(balance < -1 && data.compareTo(node.getRightNode().getData()) > 0)
            return leftRotation(node);

        //case III left-right
        if(balance > 1 && data.compareTo(node.getLeftNode().getData()) > 0) {
            node.setLeftNode(leftRotation(node.getLeftNode()));
            return rightRotation(node);
        }

        //case IIII right-left
        if(balance < -1 && data.compareTo(node.getRightNode().getData()) < 0) {
            node.setRightNode(rightRotation(node.getRightNode()));
            return leftRotation(node);
        }

        return node;

    }

    public void delete(T data) {
        if(root != null) root = delete(root, data);
    }

    private Node<T> delete(Node<T> node, T data) {

        if (node == null)
            return node;

        if (data.compareTo(node.getData()) < 0) {
            node.setLeftNode(delete(node.getLeftNode(), data));
        } else if (data.compareTo(node.getData()) > 0) {
            node.setRightNode(delete(node.getRightNode(), data));
        } else {

            if(node.getLeftNode() == null && node.getRightNode() == null) {
                System.out.println("Removing a leaf node --> "+node);
                return null;
            }

            if(node.getLeftNode() == null) {
                System.out.println("Removing the right child --> "+node);
                Node<T> tempNode = node.getRightNode();
                node = null;
                return tempNode;
            }else if(node.getRightNode() == null) {
                System.out.println("Removing the left child --> "+node);
                Node<T> tempNode = node.getLeftNode();
                node = null;
                return tempNode;
            }

            System.out.println("Removing node with two children --> "+node);
            Node<T> tempNode = getPredecessor(node.getLeftNode());
            node.setData(tempNode.getData());
            node.setLeftNode(delete(node.getLeftNode(), tempNode.getData()));

        }

        node.setHeight(Math.max(height(node.getLeftNode()), height(node.getRightNode()) + 1));
        return settleDeletion(node);

    }

    private Node<T> settleDeletion(Node<T> node) {

        int balance = getBalance(node);

        if(balance > 1){
            if(getBalance(node.getLeftNode()) < 0){
                node.setLeftNode(leftRotation(node.getLeftNode()));
            }
            return rightRotation(node);
        }

        if(balance < -1){
            if(getBalance(node.getRightNode()) > 0){
                node.setRightNode(rightRotation(node.getRightNode()));
            }
            return leftRotation(node);
        }

        return node;
    }

    private Node<T> getPredecessor(Node<T> node) {

        if(node.getRightNode() != null)
            return getPredecessor(node.getRightNode());

        System.out.println("Predecessor node --> "+node);
        return node;
    }

    private Node<T> rightRotation(Node<T> node){

        System.out.println("Rotating to the right on node: "+node);

        Node<T> tempLeftNode = node.getLeftNode();
        node.setLeftNode(tempLeftNode.getRightNode());
        tempLeftNode.setRightNode(node);

        node.setHeight(Math.max(height(node.getLeftNode()), height(node.getRightNode())) + 1);
        tempLeftNode.setHeight(Math.max(height(tempLeftNode.getLeftNode()), height(tempLeftNode.getRightNode())) + 1);

        return tempLeftNode;

    }

    private Node<T> leftRotation(Node<T> node){

        System.out.println("Rotating to the left on node: "+node);

        Node<T> tempRightNode = node.getRightNode();
        node.setRightNode(tempRightNode.getLeftNode());
        tempRightNode.setLeftNode(node);

        node.setHeight(Math.max(height(node.getLeftNode()), height(node.getRightNode())) + 1);
        tempRightNode.setHeight(Math.max(height(tempRightNode.getLeftNode()), height(tempRightNode.getRightNode())) + 1);

        return tempRightNode;
    }

    private int getBalance(Node<T> node){

        if(node == null) return 0;

        return height(node.getLeftNode()) - height(node.getRightNode());
    }

    private int height (Node<T> node){

        if(node == null) return -1;

        return node.getHeight();
    }

    @Override
    public void traverse() {

        if(root == null) return;

        inOrderTraversal(root);

    }

    private void inOrderTraversal(Node<T> node) {

        if(node.getLeftNode() != null)
            inOrderTraversal(node.getLeftNode());

        System.out.println(node);

        if(node.getRightNode() != null)
            inOrderTraversal(node.getRightNode());

    }
}
