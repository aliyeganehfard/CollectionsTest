package A_1;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class ThreadPool implements Runnable{
    private Set<String> set;
    private List<Character> letters;

    public ThreadPool(Set<String> set, List<Character> letters) {
        this.set = set;
        this.letters = letters;
    }

    @Override
    public void run() {
        Collections.shuffle(letters);
        StringBuilder word = new StringBuilder();
        for (var str : letters)
            word.append(str);
        set.add(word.toString());
    }
}
