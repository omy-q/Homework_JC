package lesson2;

import java.util.Arrays;

public class JavaArrays {
    public static void main(String[] args){

        invertArrayFirstVar();
        System.out.println();

        invertArraySecondVar();
        System.out.println();

        fillArray();
        System.out.println();
    }

    private static void invertArrayFirstVar(){
        System.out.println("Задача1. Первый вариант решения");
        int[] arr = {0, 1, 1, 0, 1, 0, 0};
        System.out.println(Arrays.toString(arr) + " - исходный массив");
        for (int i = 0; i < arr.length; i++){
            switch (arr[i]){
                case 0:
                    arr[i] = 1;
                    break;
                case 1:
                    arr[i] = 0;
                    break;
            }
        }
        System.out.println(Arrays.toString(arr) + " - инвертированный массив");
    }
    private static void invertArraySecondVar(){
        System.out.println("Задача1. Второй вариант решения");
        int[] arr = {0, 1, 1, 0, 1, 0, 0};
        System.out.println(Arrays.toString(arr) + " - исходный массив");
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == 0) arr[i] = 1;
            else arr[i] = 0;
        }
        System.out.println(Arrays.toString(arr) + " - инвертированный массив");
    }
    private static void fillArray(){
        int[] arr = new int[8];
        System.out.println("Задача2");
        for (int i = 0; i < arr.length; i++){
            arr[i] = 3 * i;
        }
        System.out.println(Arrays.toString(arr));
    }
}
