package src.Hashing;

import src.MapInterface.MyLinearMap;

import java.util.Map;

public class MyFixedHashMap<K, V> extends MyHashMap<K, V> implements Map<K, V> {

    private int size = 0;

    // 상위 클래스 clear 호출한 후 사이즈 초기화
    public void clear() {
        super.clear();
        size = 0;
    }

    public V remove(Object key) {
        MyLinearMap<K, V> map = chooseMap(key);
        size -= map.size();
        V oldValue = map.remove(key);
        size += map.size();

        return oldValue;
    }
    
    public V put(K key, V value) {
        MyLinearMap<K, V> map = chooseMap(key);
        size -= map.size();
        V oldValue = map.put(key, value);
        size += map.size();
        
        if (size() > maps.size() * FACTOR) {
            size = 0;
            rehash();
        }

        return oldValue;
    }

    public int size() {
        return this.size;
    }

}
