package org.example;

import java.util.Optional;

public interface EvictionStrategy<K> {
    void keyAccessed(K key);
    void keyAddded(K Key);
    void removed(K key);
    Optional<K> evictCandidate();
}
