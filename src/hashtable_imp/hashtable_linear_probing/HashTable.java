package hashtable_imp.hashtable_linear_probing;

public class HashTable {

    private HashItem[] hashItems;
    private int hashItemsSize;

    HashTable() {
        this.hashItems = new HashItem[Constants.TABLE_SIZE];
        hashItemsSize = 0;
    }

    public int get(int key) {

        int hashArrayIndex = hash(key);
        if (hashItems[hashArrayIndex] != null) {

            HashItem hashItem = hashItems[hashArrayIndex];
            if (hashItem.getKey() == key)
                return hashItem.getValue();
            else {
                for (int i = 0; i < hashItems.length; i++) {
                    if (hashItems[i] != null && hashItems[i].getKey() == key) {
                        return hashItems[i].getValue();
                    }
                }
            }
        }

        return -1;
    }

    public void put(int key, int value) {

        int hashArrayIndex = hash(key);
        if (hashItems[hashArrayIndex] == null) {
            hashItems[hashArrayIndex] = new HashItem(key, value);
        } else {
            for (int i = 0; i < hashItems.length; i++) {
                if (hashItems[i] == null) {
                    hashItems[i] = new HashItem(key, value);
                    return;
                }
            }
        }
    }


    public int get2(int key) {
        int hashArrayIndex = hash(key);
        while (hashItems[hashArrayIndex] != null && hashItems[hashArrayIndex].getKey() != key) {
            hashArrayIndex = (hashArrayIndex + 1) % Constants.TABLE_SIZE;
        }

        if (hashItems[hashArrayIndex] != null)
            return hashItems[hashArrayIndex].getValue();
        else
            return -1;

    }

    public void put2(int key, int value) {

        if (hashItemsSize == hashItems.length) {
            System.out.println("Hashtable is full, It can't add key " + key);
            return;
        }

        int hashArrayIndex = hash(key);
        while (hashItems[hashArrayIndex] != null)
            hashArrayIndex = (hashArrayIndex + 1) % Constants.TABLE_SIZE;

        hashItems[hashArrayIndex] = new HashItem(key, value);
        hashItemsSize++;

    }

    private int hash(int key) {
        //return key % Constants.TABLE_SIZE;
        return 1;
    }
}
