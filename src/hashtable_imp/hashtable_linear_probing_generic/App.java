package hashtable_imp.hashtable_linear_probing_generic;


import java.util.HashMap;
import java.util.Map;

public class App {

    public static void main(String... args){

        HashTable<String, Integer> hashTable = new HashTable<>();

        hashTable.put("a", 1);
        System.out.println(hashTable.size());
        hashTable.put("b", 2);
        System.out.println(hashTable.size());
        hashTable.put("c", 3);
        System.out.println(hashTable.size());
        hashTable.put("d", 4);
        System.out.println(hashTable.size());
        hashTable.put("e", 5);
        System.out.println(hashTable.size());
        hashTable.put("f", 6);
        System.out.println(hashTable.size());
        hashTable.put("g", 7);
        System.out.println(hashTable.size());
        hashTable.put("h", 8);
        System.out.println(hashTable.size());
        hashTable.put("j", 9);
        System.out.println(hashTable.size());
        hashTable.put("k", 10);
        System.out.println(hashTable.size());
        hashTable.put("l", 11);
        System.out.println(hashTable.size());
        hashTable.put("m", 12);
        System.out.println(hashTable.size());
        hashTable.put("n", 13);
        System.out.println(hashTable.size());
        hashTable.put("bb", 14);
        System.out.println(hashTable.size());
        hashTable.put("v", 15);
        System.out.println(hashTable.size());
        hashTable.put("bbc", 16);
        System.out.println(hashTable.size());
        hashTable.put("x", 17);
        System.out.println(hashTable.size());
        hashTable.put("y", 18);
        System.out.println(hashTable.size());


        hashTable.put("wq", 1);
        System.out.println(hashTable.size());
        hashTable.put("65", 2);
        System.out.println(hashTable.size());
        hashTable.put("hgf", 3);
        System.out.println(hashTable.size());
        hashTable.put("op", 4);
        System.out.println(hashTable.size());
        hashTable.put("cd", 5);
        System.out.println(hashTable.size());
        hashTable.put("wsa", 6);
        System.out.println(hashTable.size());
        hashTable.put("olp", 7);
        System.out.println(hashTable.size());
        hashTable.put("bvf", 8);
        System.out.println(hashTable.size());
        hashTable.put("cxs", 9);
        System.out.println(hashTable.size());
        hashTable.put("mn", 10);
        System.out.println(hashTable.size());
        hashTable.put("aqa", 11);
        System.out.println(hashTable.size());
        hashTable.put("xsx", 12);
        System.out.println(hashTable.size());
        hashTable.put("wer", 13);
        System.out.println(hashTable.size());
        hashTable.put("tyu", 14);
        System.out.println(hashTable.size());
        hashTable.put("op", 15);
        System.out.println(hashTable.size());
        hashTable.put("wwc", 16);
        System.out.println(hashTable.size());
        hashTable.put("npz", 17);
        System.out.println(hashTable.size());
        hashTable.put("98", 18);
        System.out.println(hashTable.size());

        System.out.println();
        System.out.println("finding");
        System.out.println(hashTable.get("a"));
        System.out.println(hashTable.get("y"));
        System.out.println(hashTable.get("hi"));
        System.out.println(hashTable.get("ubuntu"));
        System.out.println();

        System.out.println("Starting removing");
        hashTable.remove("a");
        System.out.println(hashTable.size());
        hashTable.remove("b");
        System.out.println(hashTable.size());
        hashTable.remove("c");
        System.out.println(hashTable.size());
        hashTable.remove("d");
        System.out.println(hashTable.size());
        hashTable.remove("e");
        hashTable.remove("e");
        System.out.println(hashTable.size());
        hashTable.remove("f");
        System.out.println(hashTable.size());
        hashTable.remove("g");
        System.out.println(hashTable.size());
        hashTable.remove("h");
        System.out.println(hashTable.size());
        hashTable.remove("j");
        System.out.println(hashTable.size());
        hashTable.remove("k");
        System.out.println(hashTable.size());

        Map<Integer, String> map = new HashMap<>();

    }

}
