package A_1;

import java.util.Collections;
import java.util.HashMap;
import java.util.*;

public class HashMapMain {
    public static void main(String[] args) {
        Map<String, Set<String>> map = new HashMap<>();
        Scanner scn = new Scanner(System.in);

        System.out.print("input : ");
        String input = scn.nextLine();
        String[] words = input.trim().split(" ");
        List<Character> letters = new ArrayList<>();
        if (words.length == 1) {
//          save String to List<Character>
            saveToList(letters, words[0]);
            System.out.println("length : "+getLength(letters));
//          fill Set<String> and save to map
            map.put(words[0], fillInTheSet(letters, words[0]));

//            print Map
            printHashMap(map);
        } else if (words.length == 2) {

            for (int i = 0; i < 2; i++) {
                saveToList(letters, words[i]);
                map.put(words[i], fillInTheSet(letters, words[i]));
            }

            if (Collections.disjoint(map.get(words[0]), map.get(words[1]))) {
                System.out.println("failed");
            } else {
                System.out.println("pass");
            }
        } else {
            System.out.println("wrong input!");
        }

    }

    //  save input to list of character
    private static void saveToList(List<Character> list, String word) {
        for (Character chr : word.toCharArray())
            list.add(chr);
    }

    // convert List<character> to String
    private static String convertCharacterListToString(List<Character> list) {
        StringBuilder word = new StringBuilder();
        for (Character chr : list)
            word.append(chr);
        return word.toString();
    }

    // fill value in the set
    private static Set<String> fillInTheSet(List<Character> letters, String word) {
        Set<String> set = new HashSet<>();
        set.add(word);
        while (set.size() < getLength(letters)) {
            Collections.shuffle(letters);
            set.add(convertCharacterListToString(letters));
        }
        return set;
    }
//    get length of possible word

    private static int getLength(List<Character> letters){
        int length = 1;
        int divide = 1;
        List<Character> list =new ArrayList<>(letters);
        for (int i = 1; i <= letters.size(); i++) {
            length *=i;
            int r = 1;
            if (!list.get(i-1).equals('!')){
            r = Collections.frequency(list,list.get(i-1));
            }
            Collections.replaceAll(list,list.get(i-1),'!');
            for (int k = 1; k <= r; k++) {
                divide *=k;
            }
        }
        int count = length/divide;
        return count;
    }
    // print hash map
    private static void printHashMap(Map<String, Set<String>> map) {
        System.out.println(map);
    }
}
