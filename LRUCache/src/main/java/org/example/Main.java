package org.example;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
      /*CacheClient<Integer,String> cache=new CacheService<>(3,new InmemoryCacheStore<>(),new LRUEviction<>());
      cache.put(1, "ABC");
      cache.put(2, "XYZ");
      cache.put(3, "MNO");
      cache.put(4, "PQR");
      System.out.println(cache.get(1));
      System.out.println(cache.get(2));
      System.out.println(cache.get(3));*/

      //concurrency testing
        int capacity = 5;

        CacheStore<Integer, String> store = new InmemoryCacheStore<>();

        EvictionStrategy<Integer> evictionPolicy = new LRUEviction<>();

        CacheService<Integer, String> cache =
                new CacheService<>(capacity, store, evictionPolicy);

        int numberOfThreads = 10;
        int operationsPerThread = 100;

        ExecutorService executor =
                Executors.newFixedThreadPool(numberOfThreads);

        CountDownLatch startLatch = new CountDownLatch(1);
        CountDownLatch doneLatch = new CountDownLatch(numberOfThreads);

        for (int threadId = 0; threadId < numberOfThreads; threadId++) {

            final int id = threadId;

            executor.submit(() -> {

                try {

                    // Make all threads start approximately at the same time
                    startLatch.await();

                    for (int i = 0; i < operationsPerThread; i++) {

                        int key = (id * operationsPerThread) + i;

                        cache.put(key, "value-" + key);
                        cache.get(key);
                        if (i % 20 == 0) {
                            cache.remove(key);
                        }
                    }

                } catch (InterruptedException e) {

                    Thread.currentThread().interrupt();

                } finally {
                    doneLatch.countDown();
                }
            });
        }

        System.out.println("Starting concurrency test...");

        // Release all worker threads
        startLatch.countDown();

        // Wait for all workers
        doneLatch.await();

        executor.shutdown();

        // Wait for executor termination
        executor.awaitTermination(5, TimeUnit.SECONDS);

        System.out.println("Concurrency test completed.");
        System.out.println("Final cache size = " + cache.size());
        System.out.println("Cache capacity   = " + capacity);

        if (cache.size() <= capacity) {
            System.out.println("PASS: Cache capacity was never violated.");
        } else {
            System.out.println("FAIL: Cache capacity was violated!");
        }

    }
}