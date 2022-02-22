package A_4_plus;

import java.util.*;

public class HashMapClass<K,V> implements HashMapInterface<K, V> {
    private List<K> key = new ArrayList<>();
    private List<V> value = new ArrayList<>();
    private Integer index = 0;

    @Override
    public void put(K k, V v) {
        if (containsKey(k)){
            System.out.println("already exist!");
            return;
        }

        key.add(k);
        value.add(v);
        index++;
    }

    @Override
    public boolean containsKey(K k) {
        return key.contains(k);
    }

    @Override
    public boolean isEmpty() {
        return key.isEmpty();
    }

    @Override
    public void showAll() {
        for (int i = 0; i < index; i++) {
            System.out.println("key : "+key.get(i) +" value : " + value.get(i));
        }
    }

    @Override
    public void replace(K k, V v) {
        int elem = key.indexOf(k);
        if (elem>=0)
            value.set(elem,v);
        else
            System.out.println("not found!");
    }
}
