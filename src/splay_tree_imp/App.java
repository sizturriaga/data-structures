package splay_tree_imp;

public class App {

    public static void main(String... args){
        Tree<Integer> splayTree = new SplayTree<>();
        splayTree.insert(10);
        System.out.println();
        splayTree.insert(-5);
        System.out.println();
        splayTree.insert(0);
        //System.out.println();
        //splayTree.insert(20);
        //splayTree.insert(30);

        splayTree.printRoot();

    }
}
