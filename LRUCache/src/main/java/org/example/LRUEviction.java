package org.example;

import java.util.HashMap;
import java.util.Optional;

public class LRUEviction<K> implements EvictionStrategy<K> {
    public static class Node<K>{
        K key;
        Node<K> next;
        Node<K> prev;

        public Node(K key){
          this.key=key;
        }
    }
    private final HashMap<K,Node<K>> map=new HashMap<>();
    private final Node<K> head;
    private final Node<K> tail;
    public LRUEviction(){
        head=new Node<>(null);
        tail=new Node<>(null);
        head.next=tail;
        tail.prev=head;
    }
    @Override
    public void keyAccessed(K key) {
        Node<K> node=map.get(key);
        if(node==null){
            return;
        }
        removeNodeFromDDL(node);
        addAfterHead(node);
    }
    public void removeNodeFromDDL(Node<K> node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }
    public void addAfterHead(Node<K> node){
         node.prev=head;
         node.next=head.next;
         head.next.prev=node;
         head.next=node;
    }
    @Override
    public void keyAddded(K Key) {
        Node<K> newNode=new Node<>(Key);
        map.put(Key,newNode);
        addAfterHead(newNode);
    }
    @Override
    public void removed(K key) {
        Node<K> node = map.remove(key);
        if (node != null) {
            removeNodeFromDDL(node);
        }
    }
    @Override
    public Optional<K> evictCandidate() {
        if (tail.prev == head) {
            return Optional.empty();
        }
        Node<K> removedNode = tail.prev;
        return Optional.ofNullable(removedNode.key);
    }
}
