package classimplementation;

import java.util.Arrays;

class MyHashMap<K, V> {

    public static void main(String[] args) {
//        MyHashMap<Integer, Integer> hashMap = new MyHashMap<>(2);
//        hashMap.put(1, 2);
//        hashMap.put(null, 1);
//        System.out.println(hashMap.remove(1));
//        System.out.println(hashMap.get(1));
//        hashMap.put(null, 4);
//        hashMap.put(5, 5);
//        hashMap.put(6, 6);
//        System.out.println(hashMap.get(null));
//        System.out.println(hashMap.get(5));
//        System.out.println(hashMap);
        MyHashMap<String, String> hashMap = new MyHashMap<>(2);
        hashMap.put("Aa", "Aa");
        hashMap.put("aA", "aA");
        hashMap.put("Bb", "Bb");
        hashMap.put("bB", "bB");
        hashMap.put("bB2", "bB2");
        System.out.println(hashMap.remove("Bb"));
        System.out.println(hashMap.remove("Aa"));
        System.out.println(hashMap);
    }

    private Entry<K, V>[] buckets;
    int size;
    private static final float LF = 0.75f;

    public MyHashMap(int capacity) {
        buckets = new Entry[capacity];
    }

    public V get(K key) {
        Entry<K, V> entry = buckets[getBucketIndex(key)];

        while (entry != null) {
            if (keysMatch(entry.key, key)) {
                return entry.value;
            }
            entry = entry.next;
        }
        return null;
    }

    public void put(K key, V value) {
        if (size > buckets.length * LF) {
            Entry<K, V>[] temp = buckets;
            buckets = new Entry[buckets.length * 2];
            size = 0;
            for (Entry<K, V> entry : temp) {
                while (entry != null) {
                    put(entry.key, entry.value);
                    entry = entry.next;
                }
            }
        }

        int index = getBucketIndex(key);
        if (buckets[index] == null) {
            buckets[index] = new Entry<>(key, value);
            size++;
        } else {
            Entry<K, V> entry = buckets[index];
            while (entry.next != null) {
                if (keysMatch(entry.key, key)) {
                    entry.value = value;
                    return;
                }
                entry = entry.next;
            }
            if (keysMatch(entry.key, key)) {
                entry.value = value;
            } else {
                entry.next = new Entry<>(key, value);
                size++;
            }
        }
    }

    public V remove(K key) {
        Entry<K, V> prev = buckets[getBucketIndex(key)];
        Entry<K, V> entry = prev.next;
        if (keysMatch(prev.key, key)) {
            buckets[getBucketIndex(key)] = entry;
            size--;
            return prev.value;
        }
        while (entry != null) {
            if (keysMatch(entry.key, key)) {
                V temp = entry.value;
                prev.next = entry.next;
                size--;
                return temp;
            }
            prev = entry;
            entry = entry.next;
        }
        return null;
    }

    private boolean keysMatch(K key1, K key2) {
        return (key1 != null && key1.equals(key2)) || (key2 == null && key1 == null);
    }

    private int getBucketIndex(K key) {
        return getHash(key) % buckets.length;
    }

    private int getHash(K key) {
        return key == null ? 0 : Math.abs(key.hashCode());
    }

    private static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        private Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "key=" + key +
                    ", value=" + value +
                    ", next=" + next +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "HashMap{" +
                "buckets=" + Arrays.deepToString(buckets) +
                ", size=" + size +
                '}';
    }
}