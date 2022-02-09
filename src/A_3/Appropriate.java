package A_3;

import java.util.*;

public class Appropriate implements Comparator<Integer> {

    public List<Integer> getArray(List<Integer> list) {
        List<Integer> integerList = new ArrayList<>();
        checkList(list);
        for (int i = 0; i < list.size() - 1; i = i + 2) {
            int result = compare(list.get(i), list.get(i + 1));
            if (result <= 0) {
                integerList.addAll(list.subList(i, i + 2));
            }
        }
        return integerList;
    }

    private void checkList(List<Integer> list){
        if (list.size() % 2 != 0) {
            ListIterator<Integer> iterator = list.listIterator(list.size());
            while (iterator.hasPrevious()) {
                int i = iterator.previous();
                if (i == list.size() - 1)
                    iterator.remove();
            }
        }
    }
    @Override
    public int compare(Integer first, Integer second) {
        return first.compareTo(second);
    }
}
