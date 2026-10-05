package org.example;

import java.util.Optional;
import java.util.concurrent.locks.ReentrantLock;

public class CacheService<K,V> implements CacheClient<K,V>{

    private final CacheStore<K,V> store;
    private final EvictionStrategy<K> evictionPolicy;
    private final int cap;
    private final ReentrantLock lock=new ReentrantLock();

    public CacheService(int cap, CacheStore<K, V> store, EvictionStrategy<K> evictionPolicy) {
        this.cap = cap;
        this.store = store;
        this.evictionPolicy = evictionPolicy;
    }

    //add new/existing key
    @Override
    public void put(K key, V value) {
        lock.lock();
        K evictedKey=null;
        V evictedVal=null;
        try{
            boolean isExist=store.containsKey(key);
            store.addedKey(key,value);
            if(isExist){

                evictionPolicy.keyAccessed(key);
            }else{
                evictionPolicy.keyAddded(key);
            }
            if (store.size() > cap) {
                Optional<K> candidate = evictionPolicy.evictCandidate();
                if (candidate.isPresent()) {
                    evictedKey = candidate.get();
                    store.removedKey(evictedKey);
                    evictionPolicy.removed(evictedKey); // Fixes eviction cleanup as well
                }
            }
        }finally {
            lock.unlock();
        }
    }

    //access value from cache
    @Override
    public Optional<V> get(K key) {
        lock.lock();
        try{
            Optional<V> val=store.getKey(key);
            if(val.isPresent()){
                evictionPolicy.keyAccessed(key);
                return val;
            }
        }finally {
            lock.unlock();
        }
        return Optional.empty();
    }


    @Override
    public Optional<V> remove(K key) {
        lock.lock();
        try{
          Optional<V> removedVal= store.removedKey(key);
          if(removedVal.isPresent()){
              evictionPolicy.removed(key);
          }
          return removedVal;
        }finally {
            lock.unlock();
        }
    }

    @Override
    public int size() {
        lock.lock();
        try {
            return store.size();
        } finally {
            lock.unlock();
        }
    }
}
