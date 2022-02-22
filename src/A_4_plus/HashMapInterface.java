package A_4_plus;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface HashMapInterface<K,V> {
        void put(K k ,V v);
        boolean containsKey(K k);
        boolean isEmpty();
        void showAll();
        void replace(K k , V v);
}
