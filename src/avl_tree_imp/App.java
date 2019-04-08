package avl_tree_imp;

public class App {

    public static void main(String[] args) {

/*
        Tree avl = new AvlTree();
        avl.insert(10);
        avl.insert(20);
        avl.insert(30);
        avl.insert(40);
        avl.insert(50);
        avl.insert(60);

        avl.traverse();

        Tree avl2 = new AvlTree();
        avl2.insert(3);
        avl2.insert(2);
        avl2.insert(1);

        avl2.traverse();


        Tree avl3 = new AvlTree();
        avl3.insert(3);
        avl3.insert(1);
        avl3.insert(2);

        avl3.traverse();


        Tree avl4 = new AvlTree();
        avl4.insert(3);
        avl4.insert(5);
        avl4.insert(4);

        avl4.traverse();
 */


        Tree<Integer> avlDeletionInt = new AvlTree<>();
        avlDeletionInt.insert(10);
        avlDeletionInt.insert(15);
        avlDeletionInt.insert(5);
        avlDeletionInt.insert(6);

        avlDeletionInt.delete(15);



        avlDeletionInt.traverse();

        Tree<String> avlDeletionString = new AvlTree<>();
        avlDeletionString.insert("Carlos");
        avlDeletionString.insert("Maria");
        avlDeletionString.insert("Jose");
        avlDeletionString.insert("Jesus");

        avlDeletionString.delete("Jose");

        avlDeletionString.traverse();

    }
}
