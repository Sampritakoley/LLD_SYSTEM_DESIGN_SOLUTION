package org.example;

import java.util.HashMap;
import java.util.Optional;

public class InmemoryCacheStore<K,V> implements CacheStore<K,V>{
    HashMap<K,V> mapStore=new HashMap<>();

    @Override
    public void addedKey(K key, V value) {
        mapStore.put(key,value);
    }

    @Override
    public Optional<V> getKey(K key) {
        return Optional.ofNullable(mapStore.get(key));
    }
    @Override
    public Optional<V> removedKey(K key) {
        return Optional.ofNullable(mapStore.remove(key));
    }


    @Override
    public int size() {
        return mapStore.size();
    }

    @Override
    public boolean containsKey(K key) {
        return  mapStore.containsKey(key);
    }
}
