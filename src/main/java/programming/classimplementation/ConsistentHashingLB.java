package programming.classimplementation;

import java.util.SortedMap;
import java.util.TreeMap;

public class ConsistentHashingLB {

    public static void main(String[] args) {
        LoadBalancingImpl<String> loadBalancing = new LoadBalancingImpl<>(new StringHashFunction());
        loadBalancing.add("B");
        loadBalancing.add("D");
        loadBalancing.add("H");
        loadBalancing.add("T");

        System.out.println(loadBalancing.getServer("E"));
        System.out.println(loadBalancing.getServer("Z"));
        System.out.println(loadBalancing.getServer("A"));
    }
}

class LoadBalancingImpl<T> {

    private final HashFunction<T> hashFunction;
    private final SortedMap<Integer, T> circle = new TreeMap<>();

    public LoadBalancingImpl(HashFunction<T> hashFunction) {
        this.hashFunction = hashFunction;
    }

    public void add(T node) {
        circle.put(hashFunction.hashCode(node), node);
    }

    public void remove(T node) {
        circle.remove(hashFunction.hashCode(node));

    }

    public T getServer(T key) {
        if (circle.isEmpty()) {
            return null;
        }
        int hash = hashFunction.hashCode(key);
        if (!circle.containsKey(hash)) {
            SortedMap<Integer, T> tailMap =
                    circle.tailMap(hash);
            hash = tailMap.isEmpty() ?
                    circle.firstKey() : tailMap.firstKey();
        }
        return circle.get(hash);
    }
}

interface HashFunction<T> {
    int hashCode(T t);
}

class StringHashFunction implements HashFunction<String> {

    public int hashCode(String s) {
        int hash = 7;
        for (int i = 0; i < s.length(); i++) {
            hash = hash * 31 + s.charAt(i);
        }
        return hash;
    }
}

