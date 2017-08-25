import java.util.ArrayList;

/**
 * Created by AlinaCh on 25.02.2017.
 */
public class HashTable <K, V> {

    private int INITIAL_SIZE = 128;
    private Entry<K,V>[] table;
    private int capacity;

    /**
     * initialization of hashTable with size of 128 elemenets
     */
    public void hashTable() {
        table = (Entry<K, V>[]) new Entry[INITIAL_SIZE];
        capacity = 0;
    }

    /**
     * adding element into the hashTable, increases the amount of elements
     * @param key the key value which helps to iterate through hashTable
     * @param value the value to be stored
     */
    public void add(K key, V value) {
        this.add(key, value, 0);
        capacity++;
    }

    /**
     * @param key the key value which helps to iterate through hashTable
     * @return value of required key
     */
    public V get(K key) {
        if (search(key, 0) != -1)
            return table[search(key, 0)].value;
        return null;
    }

    /**
     * @return set of all elements with key and value
     */
    public ArrayList<Entry<K,V>> entrySet() {
        ArrayList<Entry<K, V>> entryset = new ArrayList<>();
        if (!this.isEmpty()) {
            for (int i = 0; i < INITIAL_SIZE; i++) {
                if (table[i] != null) {
                    entryset.add(table[i]);
                }
            }
            return entryset;
        }
        return null;
    }

    /**
     * @return set of all keys
     */
    public ArrayList<K> keySet() {
        ArrayList<K> keys = new ArrayList<K>();
        if (!this.isEmpty()) {
            for (int i = 0; i < INITIAL_SIZE; i++) {
                if (table[i] != null) {
                    keys.add(table[i].key);
                }
            }
            return keys;
        }
        return null;
    }

    /**
     * deletes element in the hashTable
     * @param key the key value which helps to iterate through hashTable
     */
    public void remove(K key) {
        table[this.search(key, 0)] = null;
        capacity--;
    }

    /**
     * @return size of hashTable
     */
    public int size() {
        return capacity;
    }

    /**
     * @return whether hashTable is empty or not
     */
    public boolean isEmpty() {
        return capacity == 0;
    }

    /**
     * searches element in the hashTable by key index
     * @param key the key value which helps to iterate through hashTable
     * @param i iterator which helps to escape collision
     * @return index of element in the array which is searched
     */
    private int search(K key, int i) {
        int cursor = hCode(key, i);
        if (table[cursor] != null && table[cursor].key.equals(key)) {
            return cursor;
        } else if (table[cursor] != null) {
            this.search(key, i + 1);
        }
        return -1;
    }

    /**
     * @param key the key value which helps to iterate through hashTable
     * @param i iterator which helps to escape collision
     * @return the index which corresponds to the key
     */
    private int hCode(K key, int i) {
        if ((key.hashCode() + (i*i)) % INITIAL_SIZE < 0) {
            return ((key.hashCode() + (i*i)) % INITIAL_SIZE) + INITIAL_SIZE;
        }
        return (key.hashCode() + (i*i)) % INITIAL_SIZE;
    }

    /**
     * complete function of adding element into the hashTable
     * it searches the empty index or, if key element is already placed in hashTable, changes its value
     * @param key the key value which helps to iterate through hashTable
     * @param value the value to be stored
     * @param i iterator which helps to escape collision
     */
    private void add(K key, V value, int i) {
        int cursor = hCode(key, i);
        if (table[cursor] != null && table[cursor].key.equals(key)) {
            Entry<K, V> data = new Entry<K, V>();
            data.Entry(key, value);
            table[cursor] = data;
        } else if (table[cursor] != null) {
            this.add(key, value, i + 1);
        } else {
            Entry<K, V> data = new Entry<K, V>();
            data.Entry(key, value);
            table[cursor] = data;
        }
    }


}
