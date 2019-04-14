package red_black_tree_imp;

public class RedBlackTree implements Tree {

    private Node root;

    @Override
    public void traverse() {
        if(root == null) return;

        traverse(root);
    }

    private void traverse(Node node) {

        if(node.getLeftChild() != null){
            traverse(node.getLeftChild());
        }

        System.out.print(node+" - ");

        if(node.getRightChild() != null){
            traverse(node.getRightChild());
        }
    }

    private void rightRotate(Node node){
        System.out.println("Right rotating "+node);

        Node tempLeftChild = node.getLeftChild();
        node.setLeftChild(tempLeftChild.getRightChild());

        if(node.getLeftChild() != null)
            node.getLeftChild().setParent(node);

        tempLeftChild.setParent(node.getParent());

        if(tempLeftChild.getParent() == null)
            root = tempLeftChild;
        else if(node == node.getParent().getRightChild())
            node.getParent().setRightChild(tempLeftChild);
        else
            node.getParent().setLeftChild(tempLeftChild);


        tempLeftChild.setRightChild(node);
        node.setParent(tempLeftChild);
    }

    private void leftRotate(Node node){
        System.out.println("Left rotating "+node);

        Node tempRightChild = node.getRightChild();
        node.setRightChild(tempRightChild.getLeftChild());

        if(node.getRightChild() != null)
            node.getRightChild().setParent(node);

        tempRightChild.setParent(node.getParent());

        if(tempRightChild.getParent() == null)
            root = tempRightChild;
        else if(node == node.getParent().getLeftChild())
            node.getParent().setLeftChild(tempRightChild);
        else
            node.getParent().setRightChild(tempRightChild);


        tempRightChild.setLeftChild(node);
        node.setParent(tempRightChild);
    }


    @Override
    public void insert(int data) {

        Node node = new Node(data);

        root = insertIntoTree(root, node);

        fixViolation(node);

    }

    private Node insertIntoTree(Node root, Node node) {

        if(root == null) return node;

        if(node.getData() < root.getData()){
            root.setLeftChild(insertIntoTree(root.getLeftChild(),node));
            root.getLeftChild().setParent(root);
        }else if(node.getData() > root.getData()){
            root.setRightChild(insertIntoTree(root.getRightChild(),node));
            root.getRightChild().setParent(root);
        }

        return root;
    }

    private void fixViolation(Node node) {

        Node parentNode, grandParentNode;

        while (root != node && node.getNodeColor() != NodeColor.BLACK && node.getParent().getNodeColor() == NodeColor.RED){
            parentNode = node.getParent();
            grandParentNode = node.getParent().getParent();

            if(parentNode == grandParentNode.getLeftChild()){
                Node uncle = grandParentNode.getRightChild();
                //A simple recoloring - case 1 and case 4
                if(uncle != null && uncle.getNodeColor() == NodeColor.RED){
                    grandParentNode.setNodeColor(NodeColor.RED);
                    parentNode.setNodeColor(NodeColor.BLACK);
                    uncle.setNodeColor(NodeColor.BLACK);
                }else{
                    //case 2
                    if(node == parentNode.getRightChild()){
                        leftRotate(parentNode);
                        node = parentNode;
                        parentNode = node.getParent();
                    }

                    //case 3
                    rightRotate(grandParentNode);
                    NodeColor tempColor = parentNode.getNodeColor();
                    parentNode.setNodeColor(grandParentNode.getNodeColor());
                    grandParentNode.setNodeColor(tempColor);
                    node = parentNode;
                }

            }else {
                Node uncle = grandParentNode.getLeftChild();
                //A simple recoloring - case 1 and case 4
                if (uncle != null && uncle.getNodeColor() == NodeColor.RED) {
                    grandParentNode.setNodeColor(NodeColor.RED);
                    parentNode.setNodeColor(NodeColor.BLACK);
                    uncle.setNodeColor(NodeColor.BLACK);
                } else {
                    //case 2
                    if (node == parentNode.getLeftChild()) {
                        rightRotate(parentNode);
                        node = parentNode;
                        parentNode = node.getParent();
                    }

                    //case 3
                    leftRotate(grandParentNode);
                    NodeColor tempColor = parentNode.getNodeColor();
                    parentNode.setNodeColor(grandParentNode.getNodeColor());
                    grandParentNode.setNodeColor(tempColor);

                }
            }
        }

        if(root.getNodeColor() == NodeColor.RED)
            root.setNodeColor(NodeColor.BLACK);
    }
}
