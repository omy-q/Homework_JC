package lesson10;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

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

        Set<String> set = new LinkedHashSet<>();
        set.addAll(list);
        System.out.println(set);

    }
}
