package org.example;

import java.util.Optional;

public interface CacheStore<K,V> {
    void addedKey(K key, V value);
    Optional<V> getKey(K key);
    Optional<V> removedKey(K key);
    int size();
    boolean containsKey(K key);
}
