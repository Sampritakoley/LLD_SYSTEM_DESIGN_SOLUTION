package org.example;

import java.util.Optional;

public interface CacheClient<K,V> {
    public void put(K key, V value);

    public Optional<V> get(K key);

    public Optional<V> remove(K key);
    public int size();
    
}
