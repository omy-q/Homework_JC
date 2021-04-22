package lesson14;

import java.util.Arrays;

public class MainClass {

    public int[] arrayAfterFour(int[] arr) throws RuntimeException{
        int[] newArr;
        int startIndex = - 1;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == 4){
                startIndex = i + 1;
            }
        }
        if (startIndex == - 1 || startIndex == arr.length){
            throw new RuntimeException();
        } else{
            newArr = Arrays.copyOfRange(arr, startIndex, arr.length);
//            System.out.println(Arrays.toString(newArr));
        }
        return newArr;
    }

    public boolean checkArrOneAndFour(int[] arr){
        boolean isOne = false;
        boolean isFour = false;
        for (int elem : arr) {
            if (elem == 1){
                isOne = true;
            }
            if (elem == 4) {
                isFour = true;
            }
        }
        return (isOne && isFour);
    }
}

