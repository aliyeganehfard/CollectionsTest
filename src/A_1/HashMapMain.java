package A_1;

import java.util.Collections;
import java.util.HashMap;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class HashMapMain {
    public static void main(String[] args) {
        Map<String, Set<String>> map = new HashMap<>();
        Scanner scn = new Scanner(System.in);

        System.out.print("input : ");
        String input = scn.nextLine();
        String[] words = input.trim().split(" ");
        List<Character> letters = new ArrayList<>();
        if (words.length == 1) {
            long before = System.currentTimeMillis();
//          save String to List<Character>
            saveToList(letters, words[0]);
            System.out.println("length : "+getLength(letters));
//          fill Set<String> and save to map
            map.put(words[0], fillInTheSet(letters, words[0]));
//            print Map
            printHashMap(map);
            long after = System.currentTimeMillis();
            System.out.println();
            System.out.println("duration ");
            System.out.println(after-before);
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

//    // fill value in the set
//    private static Set<String> fillInTheSet(List<Character> letters, String word) {
//        Set<String> set = new HashSet<>();
//        set.add(word);
//        while (set.size() < getLength(letters)) {
//            Collections.shuffle(letters);
//            set.add(convertCharacterListToString(letters));
//        }
//        return set;
//    }

    // fill value in the set -- thread
    private static Set<String> fillInTheSet(List<Character> letters, String word) {
        Set<String> set = new HashSet<>();
        set.add(word);
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        while (set.size() < getLength(letters))
            for (int i = 0; i < 1; i++)
                executorService.execute(new ThreadPool(set,letters));
        executorService.shutdown();
        try {
            executorService.awaitTermination(1,TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return set;
    }


//    get length of possible word

//      word : 4 * 3 * 2 * 1 / 1 = 24
//      wood : 4 * 3 * 2 * 1 / 2 * 1 = 12
//      wooo : 4 * 3 * 2 * 1 / 3 * 2 * 1 = 4
//      wwww : 4 * 3 * 2 * 1 / 4 * 3 * 2 * 1 = 1

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
//        System.out.println(map);
        for (var m : map.keySet()) {
            System.out.print("key: " + m+" value : "+map.get(m));
        }
    }
}
