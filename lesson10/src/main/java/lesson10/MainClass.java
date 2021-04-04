package lesson10;

import java.util.ArrayList;
import java.util.List;

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

    }
}
