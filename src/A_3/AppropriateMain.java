package A_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppropriateMain {
    public static void main(String[] args) {
        System.out.println("example input : 3 7 9 2 5 5 8 5 6 3 4 7 3 1");
        System.out.print("Enter your input : ");
        Scanner scn = new Scanner(System.in);
        List<String> value = new ArrayList<>(List.of(scn.nextLine().split(" ")));
        List<Integer> number = new ArrayList<>();

        try {
            for (String str : value) {
                number.add(Integer.valueOf(str));
            }
        } catch (Exception e) {
            System.out.println("wrong input!");
        }

        var appropriate = new Appropriate();
        for (int digit : appropriate.getArray(number)) {
            System.out.print(digit + " , ");
        }
    }
}
