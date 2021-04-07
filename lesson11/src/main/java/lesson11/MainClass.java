package lesson11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainClass {

    public static void main(String[] args){
        Integer[] arr1 = {5, 9, 0};
        String[] arr2 = {"Hello", "!", "world"};
        printArr(arr1);
        printArr(swapEl(arr1, 1, 0));
        printArr(arr2);
        printArr(swapEl(arr2, 1, 2));

        typeConversion(arr2);

        Fruit apple = new Apple(0.8f);
        Fruit orange = new Orange(1.1f);
        System.out.println("apple weight: " + apple.getWeight());
        System.out.println("orange weight: " + orange.getWeight());

    }

    private static <E> E[] swapEl(E[] array, int index1, int index2){
        E buffer = array[index1];
        array[index1] = array[index2];
        array[index2] = buffer;
        return array;
    }

    private static <E> void printArr(E[] arr){
        System.out.print("[ ");
        for (E el:arr) {
            System.out.print(el + " ");
        }
        System.out.print("]\n");
    }

    private static <E> void typeConversion(E[] array){
        ArrayList<E> arrayList = new ArrayList<>(Arrays.asList(array));
        System.out.println("Convert Array to ArrayList:" + arrayList.getClass().getName());
    }

}
