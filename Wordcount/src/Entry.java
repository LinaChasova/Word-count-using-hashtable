/**
 * Created by AlinaCh on 25.02.2017.
 */
public class Entry<K, V> extends Object {

    public K key;
    public V value;

    /**
     * initializing of object
     * @param key index
     * @param value its value
     */
    public void Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }


}
