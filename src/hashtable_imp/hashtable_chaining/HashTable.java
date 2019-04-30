package hashtable_imp.hashtable_chaining;

public class HashTable {

    private HashItem[] hashItems;

    HashTable(){
        this.hashItems = new HashItem[Constants.TABLE_SIZE];
    }

    public int get(int key){
        int hashArrayIndex  = hash(key);

        if(hashItems[hashArrayIndex] != null){

            HashItem hashItem = hashItems[hashArrayIndex];
            while (hashItem != null){
                if(hashItem.getKey() == key)
                    return hashItem.getValue();

                hashItem = hashItem.getHashItem();
            }
        }

        return -1;
    }

    public void put(int key, int value){

        int hashArrayIndex  = hash(key);
        if(hashItems[hashArrayIndex] == null){
            System.out.println("There is not a collision with key "+key);
            hashItems[hashArrayIndex] = new HashItem(key, value);
        }else{
            System.out.println("There is a collision with key "+key);
            System.out.println("hashArrayIndex "+hashArrayIndex);
            HashItem hashItem = hashItems[hashArrayIndex];

            while (hashItem.getHashItem() != null)
                hashItem = hashItem.getHashItem();

            hashItem.setHashItem(new HashItem(key, value));
        }
    }

    private int hash(int key){
        return key % Constants.TABLE_SIZE;
        //return 1;
    }
}
