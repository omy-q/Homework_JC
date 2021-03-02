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

        changeArray();
        System.out.println();

        fillDiagonalArray();
        System.out.println();

        searchMinMaxEll();
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
    private static void changeArray(){
        System.out.println("Задача3");
        int[] arr =  {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(arr) + " - исходный массив");
        for (int i = 0; i < arr.length; i++){
            if (arr[i] < 6) arr[i] = arr[i] * 2;
        }
        System.out.println(Arrays.toString(arr) + " - измененный массив");

    }
    private static void fillDiagonalArray(){
        System.out.println("Задача4");
        int[][] arr = new int[10][10];
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++){
                if (j == i || j == arr[i].length - 1 - i){
                    arr[i][j] = 1;
                }
            }
            System.out.println(Arrays.toString(arr[i]));
        }
    }
    private static void searchMinMaxEll(){
        System.out.println("Задача5");
        int[] arr = {2, 5, 9, 3, 0, -6, -1, 15};
        System.out.println(Arrays.toString(arr) + " - исходный массив");
        int max = arr[0], min = arr[0];
        for (int ell:arr) {
            if (ell > max) max = ell;
            if (ell < min) min = ell;
        }
        System.out.println("Минимальный элемент: " + min);
        System.out.println("Максимальный элемент: " + max);
    }
}
