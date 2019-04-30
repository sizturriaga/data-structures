package hashtable_imp.hashtable_linear_probing;

public class App {

    public static void main(String... args){

        HashTable hashTable = new HashTable();
        hashTable.put2(1,10);
        hashTable.put2(2,20);
        hashTable.put2(3,30);
        hashTable.put2(4,40);
        hashTable.put2(5,50);
        hashTable.put2(6,60);
        hashTable.put2(7,70);
        hashTable.put2(8,80);
        hashTable.put2(9,90);
        hashTable.put2(10,100);
        hashTable.put2(11,110);
        hashTable.put2(12,120);
        hashTable.put2(13,130);

        System.out.println();
        int key = 2;
        System.out.println("getting value of key "+key+" -> "+hashTable.get2(key));

    }
}
