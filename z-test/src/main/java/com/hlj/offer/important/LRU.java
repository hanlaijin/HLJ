package com.hlj.offer.important;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by hanlaijin@xiaomi.com on 18-10-19.
 */
public class LRU<K, V> {
    private Map<K, Entry<K, V>> map;
    private Entry<K, V> head;
    private Entry<K, V> tail;
    private final int MAX_SIZE;

    public LRU() {
        map = new ConcurrentHashMap<>();
        MAX_SIZE = 10;
    }

    public void put(K key, V value) {
        Entry<K, V> e = get(key);
        if (e != null) {
            e.value = value;
        } else {
            e = new Entry<>(key, value);
            if (map.size() == MAX_SIZE) {
                map.remove(tail.key);
                removeListTail();
            }
            map.put(key, e);
        }
        moveToHead(e);
    }

    public Entry<K, V> get(K key) {
        Entry<K, V> e = get(key);
        if (e != null) {
            moveToHead(e);
            return e;
        }
        return null;
    }

    public void remove(K key) {
        Entry<K, V> e = get(key);
        if (e != null) {
            map.remove(key);
            if (e == head) {
                Entry next = head.next;
                head.next = null;
                head = next;
                head.pre = null;
            } else if (e == tail) {
                Entry pre = tail.pre;
                tail.pre = null;
                tail = pre;
                pre.next = null;
            } else {
                e.next.pre = e.pre;
                e.pre.next = e.next;
            }
        }
    }

    private void removeListTail() {
        if (tail != null) {
            Entry pre = tail.pre;
            if (pre!=null) {
                tail.pre = null;
                tail = pre;
                pre.next = null;
            } else {
                head = null;
                tail = null;
            }
        }
    }

    private void moveToHead(Entry<K, V> node) {
        // TODO: 18-10-22  
    }

    private class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> pre;
        Entry<K, V> next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        LRU lru = new LRU();
    }
}
