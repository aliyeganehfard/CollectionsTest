package A_2;

import java.util.*;

public class TreeSetMain {
    public static void main(String[] args) {
        Character[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g',
                'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
                'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

        List<Character> list = Arrays.asList(letters);

        Set<Character> first = new TreeSet<>();
        Set<Character> second = new TreeSet<>();

//        fill the Sets
        fillTreeSet(first, list);
        fillTreeSet(second, list);
//        print the Sets
        System.out.print("first set content :\t\t");
        printTreeSet(first);

        System.out.print("second set content :\t");
        printTreeSet(second);

        // print merge of Sets
        System.out.print("merge Sets content :\t");
        printTreeSet(merge(first,second));

//        print sharing of Sets
        System.out.print("sharing Sets content :\t");
        printTreeSet(sharing(first,second));
    }

    private static void fillTreeSet(Set<Character> set, List<Character> list) {
        Collections.shuffle(list);
        set.addAll(list.subList(0, 10));
    }

    private static void printTreeSet(Set<Character> set) {
        for (Character chr : set)
            System.out.print(chr + "\t");
        System.out.println();
    }

    private static Set<Character> merge(Set<Character> first, Set<Character> second) {
        Set<Character> set = new TreeSet<>(first);
        set.addAll(second);
        return set;
    }

    private static Set<Character> sharing(Set<Character> first, Set<Character> second) {
        Set<Character> set = new TreeSet<>(first);
        set.retainAll(second);
        return set;
    }
}
