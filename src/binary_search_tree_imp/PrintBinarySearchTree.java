package binary_search_tree_imp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrintBinarySearchTree<T extends Comparable<T>> {
	
	public void printNode(Node<T> root) {
        int maxLevel = PrintBinarySearchTree.maxLevel(root);
        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }
	
	private void printNodeInternal(List<Node<T>> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || PrintBinarySearchTree.isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

		PrintBinarySearchTree.printWhitespaces(firstSpaces);

        List<Node<T>> newNodes = new ArrayList<Node<T>>();
        for (Node<T> node : nodes) {
            if (node != null) {
                System.out.print(node.getData());
                newNodes.add(node.getLeftChild());
                newNodes.add(node.getRightChild());
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            PrintBinarySearchTree.printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                PrintBinarySearchTree.printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    PrintBinarySearchTree.printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).getLeftChild() != null)
                    System.out.print("/");
                else
                    PrintBinarySearchTree.printWhitespaces(1);

                PrintBinarySearchTree.printWhitespaces(i + i - 1);

                if (nodes.get(j).getRightChild() != null)
                    System.out.print("\\");
                else
                    PrintBinarySearchTree.printWhitespaces(1);

                PrintBinarySearchTree.printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }
	
	   private static void printWhitespaces(int count) {
	        for (int i = 0; i < count; i++)
	            System.out.print(" ");
	    }

	    private static <T extends Comparable<?>> int maxLevel(Node<T> node) {
	        if (node == null)
	            return 0;

	        return Math.max(PrintBinarySearchTree.maxLevel(node.getLeftChild()), PrintBinarySearchTree.maxLevel(node.getRightChild())) + 1;
	    }

	    private static <T> boolean isAllElementsNull(List<T> list) {
	        for (Object object : list) {
	            if (object != null)
	                return false;
	        }

	        return true;
	    }

		


}
