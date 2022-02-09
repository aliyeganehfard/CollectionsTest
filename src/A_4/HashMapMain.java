package A_4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HashMapMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        Map<String,String> map = new HashMap<>();
        String key , value;
        while (flag) {
            operation();
            System.out.print("Enter the operation number : ");
            switch (scanner.nextInt()) {
                case 1:
                    scanner.nextLine();
                    System.out.print("Enter the key : ");
                    key = scanner.nextLine();
                    System.out.print("Enter the value : ");
                    value = scanner.nextLine();
                    if (IsExists(map,key)) {
                        System.out.println("this key already exists!");
                        break;
                    }
                    map.put(key,value);
                    break;
                case 2:
                    scanner.nextLine();
                    System.out.print("Enter the key : ");
                    key = scanner.nextLine();
                    if (!IsExists(map , key)){
                        System.out.println("not exists!");
                        break;
                    }
                    System.out.println("value is : "+map.get(key));
                    break;
                case 3:
                    System.out.println("map state : "+ map.isEmpty());
                    break;
                case 4:
                    printMap(map);
                    break;
                case 5:
                    scanner.nextLine();
                    System.out.print("enter the key : ");
                    key = scanner.nextLine();
                    System.out.print("enter new value : ");
                    value = scanner.nextLine();

                    if (!IsExists(map,key)){
                        System.out.println("this key not exit!");
                        break;
                    }

                    map.replace(key,value);
                    break;
                default:
                    System.out.println("wrong input");
                    break;
            }
        }
    }

    private static boolean IsExists(Map<String,String> map , String key){
        return map.containsKey(key);
    }
    private static void printMap(Map<String,String> map){
        for (String str: map.keySet()) {
            System.out.println("key : { "+ str + " } \t value :{ " + map.get(str)+" }");
        }
    }
    private static void operation() {
        System.out.println("1. Insert ");
        System.out.println("2. find by specific key ");
        System.out.println("3. is empty ");
        System.out.println("4. find all ");
        System.out.println("5. replace ");
    }
}
