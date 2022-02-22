package A_4_plus;

public class HashMain {
    public static void main(String[] args) {
        HashMapClass<String,String> map = new HashMapClass<>();
        map.put("ali","yegane");
        map.put("majid","majidi");
        System.out.println("map is empty : "+map.isEmpty());
        map.showAll();
        map.replace("majid","mohammadi");
        map.showAll();
        System.out.println("contains ali : "+map.containsKey("ali"));


    }
}
