package hashtable_imp.hashtable_linear_probing_generic;

@SuppressWarnings("unchecked")
public class HashTable<Key, Value> {

    private Key[] keys;
    private Value[] values;
    private int numOfItem;
    private int capacity;

    HashTable(){
        this.keys = (Key[]) new Object[Constants.TABLE_SIZE];
        this.values = (Value[]) new Object[Constants.TABLE_SIZE];
        this.capacity = Constants.TABLE_SIZE;
        this.numOfItem = 0;
    }

    HashTable(int newCapacity){
        this.keys = (Key[]) new Object[newCapacity];
        this.values = (Value[]) new Object[newCapacity];
        this.capacity = newCapacity;
        this.numOfItem = 0;
    }

    public Value get(Key key){

        if(key == null) return null;

        int index = hash(key);

        while(keys[index] != null){
            if(keys[index].equals(key))
                return values[index];

            index = (index + 1) % capacity;

        }

        return null;
    }

    public void put(Key key, Value value){

        if(key == null || value == null) return;

        if (size() >= (capacity * 0.75)){
            System.out.println("Doubling the size of the hash table...");
            resize(2 * capacity);
        }

        int index = hash(key);

        while (keys[index] != null){
            if(keys[index].equals(key)){
                values[index] = value;
                return;
            }
            index = (index + 1) % capacity;
        }

        keys[index] = key;
        values[index] = value;
        numOfItem++;

    }

    public void remove(Key key){

        if(isEmpty() || key == null) return;

        int index = hash(key);

        if(keys[index] == null) return;

        while (!keys[index].equals(key)){
            index = (index + 1) % capacity;
        }

        keys[index] = null;
        values[index] = null;
        numOfItem--;

        //check it out this piece of code
        while (keys[index] != null){
            Key keyTemp = keys[index];
            Value valueTemp = values[index];

            keys[index] = null;
            values[index] = null;

            numOfItem--;

            put(keyTemp, valueTemp);
        }

        if(size() <= capacity / 3){
            resize(capacity / 2);
            System.out.println("Dividing the size of the hash table...");
        }

    }

    private void resize(int newCapacity) {

        HashTable<Key, Value> newTable = new HashTable<>(newCapacity);
        for (int i = 0; i < capacity; i++) {
            if(keys[i] != null)
                newTable.put(keys[i], values[i]);
        }

        this.keys = newTable.getKeys();
        this.values = newTable.getValues();
        this.capacity = newTable.getCapacity();

    }


    public int size() {
        return this.numOfItem;
    }

    public boolean isEmpty(){
        return this.numOfItem == 0;
    }

    private int hash(Key key){
        return Math.abs(key.hashCode()) % this.capacity;
    }

    public Key[] getKeys() {
        return keys;
    }

    public Value[] getValues() {
        return values;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
