package lesson10;

import java.util.LinkedHashMap;
import java.util.Locale;

public class PhoneBook{
    private LinkedHashMap<String, String> map = new LinkedHashMap<>();

    public void add(String surname, String number){
        if (map.containsKey(surname.toLowerCase())){
            map.put(surname.toLowerCase(), map.get(surname.toLowerCase()) + ";" + number);
        }else map.put(surname.toLowerCase(), number);
    }

    public void get(String surname){
        if (map.containsKey(surname.toLowerCase())){
            System.out.println(surname + ":");
            for(String number:map.get(surname.toLowerCase()).split(";"))
                System.out.println(number);
        } else System.out.println("There is no such surname in the phonebook");
    }

}
