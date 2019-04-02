package binary_search_tree_imp;

public class App {

	public static void main(String[] args) {

		Tree<Integer> bst = new BinarySearchTree<>();
		bst.insert(13);
		bst.insert(-12);
		bst.insert(4);
		bst.insert(9);
		bst.insert(-6);
		bst.insert(21);
		bst.insert(5);
		bst.insert(35);
		
		System.out.println("Max: "+bst.getMaxValue());
		System.out.println("Min: "+bst.getMinValue());
		
		bst.traversal();
		
		Tree<String> bst2 = new BinarySearchTree<>();
		bst2.insert("Juan");
		bst2.insert("Maria");
		bst2.insert("Carlos");
		bst2.insert("Fernando");
		bst2.insert("Pedro");
		bst2.insert("Jessica");
		bst2.insert("Monica");
		bst2.insert("Tomas");
		
		System.out.println("\n");
		System.out.println("Max: "+bst2.getMaxValue());
		System.out.println("Min: "+bst2.getMinValue());
		
		bst2.traversal();
		
		Tree<Integer> bstCompare1 = new BinarySearchTree<>();
		bstCompare1.insert(13);
		bstCompare1.insert(-6);
		bstCompare1.insert(4);
		bstCompare1.insert(9);
		bstCompare1.insert(-12);
		bstCompare1.insert(21);
		bstCompare1.insert(5);
		bstCompare1.insert(35);
		
		System.out.println("\n");
		PrintBinarySearchTree<Integer> printBinarySearchTree = new PrintBinarySearchTree<>();
		printBinarySearchTree.printNode(bstCompare1.getRoot());
		
		Tree<Integer> bstCompare2 = new BinarySearchTree<>();
		bstCompare2.insert(13);
		bstCompare2.insert(-12);
		bstCompare2.insert(4);
		bstCompare2.insert(9);
		bstCompare2.insert(-6);
		bstCompare2.insert(21);
		bstCompare2.insert(5);
		bstCompare2.insert(35);
		
		TreeCompareHelper<Integer> compareHelper = new TreeCompareHelper<>();
		System.out.println(compareHelper.compareTree(bstCompare1.getRoot(), bstCompare2.getRoot()));
		
		
		KthSmallestLargestItem<Integer> item = new KthSmallestLargestItem<>();
		System.out.println(item.getKthSmallestLargestItem(bstCompare2.getRoot(), 7));
		
		Tree<Person> family = new BinarySearchTree<Person>();
		family.insert(new Person("Kevin", 47));
		family.insert(new Person("Tommy", 21));
		family.insert(new Person("Mark", 34));
		family.insert(new Person("Bill", 20));
		family.insert(new Person("Justin", 23));
		family.insert(new Person("Sam", 38));
		family.insert(new Person("Sam", 55));
		family.insert(new Person("Sam", 68));
		
		SumAges ages = new SumAges();
		System.out.println(ages.getSumAges(family.getRoot()));
	}

}
