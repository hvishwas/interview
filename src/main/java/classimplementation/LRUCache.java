package classimplementation;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> {
    private int maxCapacity;
    private Map<K, Entry<K, V>> cache = new HashMap<>();
    private Entry<K, V> head;
    private Entry<K, V> tail;
    private int cacheHits;
    private int cacheMisses;

    public LRUCache(int maxCapacity) {
        this.maxCapacity = maxCapacity;
//        map = Collections.synchronizedMap(new LinkedHashMap<K, V>(maxCapacity, 0.75f, true){
//            @Override
//            protected boolean removeEldestEntry(Map.Entry<K, V> entry) {
//                return size() > maxCapacity;
//            }
//        });
        Thread thread = new Thread(new TTLHandler());
        thread.setName("LRU Cache TTL Handler");
        thread.setDaemon(true);
        thread.start();
    }

    public V get(K key) {
        Entry<K, V> entry = null;
        synchronized(this) {
            entry = cache.get(key);
            if(entry == null) {
                cacheMisses++;
                return null;
            } else {
                cacheHits++;
                removeEntry(entry);
                appendEntry(entry);
                return entry.value;
            }
        }
    }

    public void put(K key, V value) {
        synchronized (this) {
            Entry<K, V> entry = cache.get(key);
            if (entry == null) {
                if (cache.size() == maxCapacity) {
                    remove(head.key);
                }
                entry = new Entry<>(key, value);
                cache.put(key, entry);
                appendEntry(entry);
            } else {
                removeEntry(entry);
                appendEntry(entry);
                entry.value = value;
            }
        }
    }

    public void remove(K key) {
        synchronized (this) {
            removeEntry(cache.remove(key));
        }
    }

    public void clear() {
        synchronized (this) {
            cacheHits = cacheMisses = 0;
            cache.clear();
            head = tail = null;
        }
    }

    private void removeEntry(Entry<K, V> entry) {
        if (entry == null) {
            return;
        }
        if (entry.previous == null) {
            head = entry.next;
        } else {
            entry.previous.next = entry.next;
        }
        if (entry.next == null) {
            tail = entry.previous;
        } else {
            entry.next.previous = entry.previous;
        }
    }

    private void appendEntry(Entry<K, V> entry) {
        if (entry == null) {
            return;
        }
        if (tail == null) {
            head = tail = entry;
        } else {
            tail.next = entry;
            entry.next = null;
            entry.previous = tail;
            tail = entry;
        }
    }

    private static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> previous;
        Entry<K, V> next;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private void cleanUp (){

    }
    private class TTLHandler implements Runnable {
//***************************** have a priority Queue ******************************
        @Override
        public void run() {
            while(true) {
                for(Map.Entry<K, Entry<K, V>> entry: cache.entrySet()) {

                }
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}