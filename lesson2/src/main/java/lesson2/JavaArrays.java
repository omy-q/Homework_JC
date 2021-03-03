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

        int[] arr = {2, 2, 2, 1, 2, 2, 10, 1};
        System.out.println("Сумма левой и правой частей массива равны? " + checkBalance(arr));
        System.out.println();

        int[] arr1 = {1, 2, 3, 4, 5, 6};
        shiftArrayFirstVar(arr1, -8);
        System.out.println();

//        int[] arr2 = {1, 2, 3, 4, 5, 6};
        shiftArraySecondVar(arr1, -8);
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
    private static boolean checkBalance(int[] arr){
        System.out.println("Задача 6");
        System.out.println(Arrays.toString(arr) + " - исходный массив");
        int sum1 = 0, sum2 = 0;
        for (int i = 0, j = arr.length - 1; i <= j;) {
            if (sum1 > sum2){
                sum2 += arr[j];
                j--;
            }
            else {
                sum1 += arr[i];
                i++;
            }
        }
        return (sum1 == sum2);
    }
    private static void shiftArrayFirstVar(int[] arr, int n){
        System.out.println("Задача7. Первый вариант решение с использованием нового массива");
        System.out.println(Arrays.toString(arr) + " - исходный массив");
        int[] new_arr = new int[arr.length];
        if (n < 0) n = (n % arr.length) + arr.length;
        for (int i = 0; i <arr.length; i++){
            int j = i + n;
            if (j > arr.length - 1) j %= arr.length;
            new_arr[j] = arr[i];
        }
        System.out.println(Arrays.toString(new_arr) + " - полученный массив");
    }
    private static void shiftArraySecondVar(int[] arr, int n){
        System.out.println("Задача7. Второй вариант решение без использования доп. массива");
        System.out.println(Arrays.toString(arr) + " - исходный массив");
        if (n < 0) n = (n % arr.length) + arr.length;
        while(n > 0){
            int buffer = arr[0], buffer2;
            for (int i = 0; i < arr.length; i++){
                int j = i + 1;
                if (j > arr.length - 1) j = j - arr.length;
                buffer2 = arr[j];
                arr[j] = buffer;
                buffer = buffer2;
            }
            n--;
        }
        System.out.println(Arrays.toString(arr) + " - полученный массив");
    }
}
