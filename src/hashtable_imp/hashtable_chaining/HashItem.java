package hashtable_imp.hashtable_chaining;

public class HashItem {

    private int key;
    private int value;
    private HashItem hashItem;

    public HashItem(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public HashItem getHashItem() {
        return hashItem;
    }

    public void setHashItem(HashItem hashItem) {
        this.hashItem = hashItem;
    }
}
