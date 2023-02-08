package ua.com.alevel.db;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Dictionary<K, V> {

    private final ArrayList<Two<K, V>> twoArrayList = new ArrayList<>();
    private int size = 0;

    public void putAll(Dictionary<K, V> dictionary) {
        for (Two<K, V> dataTwo : dictionary.getTwoArrayList()) {
            K dataKey = dataTwo.key;
            V dataValue = dataTwo.value;
            this.put(dataKey, dataValue);
        }
    }

    public boolean containsKey(K key) {
        boolean containsKey = false;
        for (Two<K, V> dataTwo : this.twoArrayList) {
            if (dataTwo.key.equals(key)) {
                containsKey = true;
                break;
            }
        }
        return containsKey;
    }

    public V get(K key) {
        V value = null;
        for (Two<K, V> dataTwo : this.twoArrayList) {
            K dataKey = dataTwo.key;
            if (dataKey.equals(key)) {
                value = dataTwo.value;
                break;
            }
        }
        if (value == null) {
        }
        return value;
    }

    public boolean remove(K key) {
        boolean hasKey = false;
        for (Two<K, V> dataTwo : this.twoArrayList) {
            if (dataTwo.key.equals(key)) {
                this.twoArrayList.remove(dataTwo);
                size--;
                hasKey = true;
                break;
            }
        }
        return hasKey;
    }

    public boolean put(K key, V value) {
        if (!containsKey(key)) {
            Two<K, V> newTwo = new Two<>(key, value);
            twoArrayList.add(newTwo);
            size++;
        } else {
            for (Two<K, V> dataTwo : this.twoArrayList) {
                if (dataTwo.key.equals(key)) {
                    dataTwo.value = value;
                }
            }
        }
        return true;
    }

    public ArrayList<Two<K, V>> getTwoArrayList() {
        return twoArrayList;
    }

    public boolean clear() {
        Two<K, V>[] two;
        if ((two = twoArrayList.toArray(new Two[0])) != null) {
        }
        this.size = 0;
        return true;
    }

    public Set<K> keySet() {
        HashSet<K> keySet = new HashSet<>();
        for (Two<K, V> dataTwo : this.twoArrayList) {
            keySet.add(dataTwo.key);
        }
        return keySet;
    }

    public Collection<V> values() {
        Collection<V> valueCollection = new ArrayList<>();
        for (Two<K, V> dataTwo : this.twoArrayList) {
            valueCollection.add(dataTwo.value);
        }
        return valueCollection;
    }

    @Override
    public String toString() {
        return "Dictionary-" +
                "twoArrayList=" + twoArrayList +
                ", size=" + size +
                ':';
    }

    private class Two<K, V> {
        private final K key;
        private V value;

        private Two(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}