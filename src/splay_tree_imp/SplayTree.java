package splay_tree_imp;

public class SplayTree<T extends Comparable<T>> implements Tree<T> {

    private int size;
    private Node<T> rootNode;

    @Override
    public void insert(T data) {
        Node<T> tempNode = this.rootNode;
        Node<T> parentNode = null;

        while (tempNode != null){
            parentNode = tempNode;

            if(parentNode.getData().compareTo(data) < 0){
                tempNode = tempNode.getRightNode();
            }else{
                tempNode = tempNode.getLeftNode();
            }
        }

        tempNode = new Node<>(data);
        tempNode.setParentNode(parentNode);

        if(parentNode == null){
            this.rootNode = tempNode;
        }else if(parentNode.getData().compareTo(data) < 0){
            parentNode.setRightNode(tempNode);
        }else{
            parentNode.setLeftNode(tempNode);
        }

        splay(tempNode);
        size++;

    }

    private void splay(Node<T> node) {

        while (node.getParentNode() != null){

            //ZIG SITUATION
            if(node.getParentNode().getParentNode() == null){
                if(node.getParentNode().getLeftNode() == node){
                    rightRotate(node.getParentNode());
                }else{
                    leftRotate(node.getParentNode());
                }

            //ZIG-ZIG SITUATION
            }else if(node.getParentNode().getLeftNode() == node &&
                     node.getParentNode().getParentNode().getLeftNode() == node.getParentNode()){
                rightRotate(node.getParentNode().getParentNode());
                rightRotate(node.getParentNode());
            }else if(node.getParentNode().getRightNode() == node &&
                     node.getParentNode().getParentNode().getRightNode() == node.getParentNode()){
                leftRotate(node.getParentNode().getParentNode());
                leftRotate(node.getParentNode());

            //ZIG-ZAG SITUATION
            }else if(node.getParentNode().getLeftNode() == node &&
                    node.getParentNode().getParentNode().getRightNode() == node.getParentNode()){
                rightRotate(node.getParentNode());
                leftRotate(node.getParentNode());
            }else{
                leftRotate(node.getParentNode());
                rightRotate(node.getParentNode());
            }
        }
    }

    @Override
    public Node<T> find(T data) {

        Node<T> tempNode = this.rootNode;

        while (tempNode != null){

            if(tempNode.getData().compareTo(data) < 0){
                tempNode = tempNode.getRightNode();
            }else if(tempNode.getData().compareTo(data) > 0){
                tempNode = tempNode.getLeftNode();
            }else{
                splay(tempNode);
                return tempNode;
            }
        }

        return null;
    }

    private void leftRotate(Node<T> node){

        System.out.println("Left rotating "+node);

        Node<T> tempNode = node.getRightNode();

        if(tempNode != null){
            node.setRightNode(tempNode.getLeftNode());

            if(tempNode.getLeftNode() != null)
                tempNode.getLeftNode().setParentNode(node);

            tempNode.setParentNode(node.getParentNode());
        }


        if(node.getParentNode() == null)
            rootNode = tempNode;
        else if(node == node.getParentNode().getLeftNode())
            node.getParentNode().setLeftNode(tempNode);
        else
            node.getParentNode().setRightNode(tempNode);

        if(tempNode != null)
            tempNode.setLeftNode(node);

        node.setParentNode(tempNode);

    }

    private void rightRotate(Node<T> node){
        System.out.println("Right rotating "+node);

        Node<T> tempNode = node.getLeftNode();

        if(tempNode != null){
            node.setLeftNode(tempNode.getRightNode());

            if(tempNode.getRightNode() != null)
                tempNode.getRightNode().setParentNode(node);

            tempNode.setParentNode(node.getParentNode());
        }


        if(node.getParentNode() == null)
            rootNode = tempNode;
        else if(node == node.getParentNode().getRightNode())
            node.getParentNode().setRightNode(tempNode);
        else
            node.getParentNode().setLeftNode(tempNode);

        if(tempNode != null)
            tempNode.setRightNode(node);

        node.setParentNode(tempNode);
    }

    @Override
    public Node<T> getMin() {
        return null;
    }

    @Override
    public Node<T> getMax() {
        return null;
    }

    @Override
    public void inOrderTraversal() {
        if(rootNode == null) return;

        traverse(rootNode);
    }

    @Override
    public void printRoot() {
        System.out.println(this.rootNode);
    }

    private void traverse(Node node) {

        if(node.getLeftNode() != null){
            traverse(node.getLeftNode());
        }

        System.out.println(node+" - ");

        if(node.getRightNode() != null){
            traverse(node.getRightNode());
        }
    }
}
