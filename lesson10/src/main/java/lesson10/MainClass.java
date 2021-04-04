package lesson10;

import java.util.*;

public class MainClass {

    public static void main(String[] args){
        List<String> list = new ArrayList<>(20);
        for(int i = 0; i < 5; i++){
            list.add("word" + (i + 1));
            list.add("word" + (i + 1));
            list.add("word" + (i + 1));
            list.add("word" + (i + 1));
        }
        System.out.println(list);
        System.out.println();

        Set<String> set = new LinkedHashSet<>();
        set.addAll(list);
        System.out.println(set);
        System.out.println();

        System.out.println(getQuantity(list));
        System.out.println();

        PhoneBook phonebook = new PhoneBook();
        phonebook.add("Ivanov", "+789465231");
        phonebook.add("Kopylov", "61-26-03");
        phonebook.add("Kopylov", "+79456123502");
        phonebook.add("Suslova", "231645");
        phonebook.add("Ivanov", "12-56-78");

        phonebook.get("Ivanov");
        phonebook.get("kopylov");
        phonebook.get("Suslova");
        phonebook.get("Bobrova");
    }

    public static LinkedHashMap getQuantity(List<String> words){
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        Iterator<String> iter = words.iterator();
        while (iter.hasNext()){
            String key = iter.next();
            if (map.containsKey(key)){
                map.put(key, map.get(key) + 1);
            } else map.put(key, 1);
        }
        return map;
    }
}
