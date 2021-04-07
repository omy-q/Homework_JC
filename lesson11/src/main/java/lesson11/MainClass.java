package lesson11;

import java.util.List;

public class MainClass {

    public static void main(String[] args){
        Integer[] arr1 = {5, 9, 0};
        String[] arr2 = {"Hello", "!", "world"};
        printArr(arr1);
        printArr(swapEl(arr1, 1, 0));
        printArr(arr2);
        printArr(swapEl(arr2, 1, 2));

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

}
