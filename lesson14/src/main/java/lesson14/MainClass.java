package lesson14;

import java.util.Arrays;

public class MainClass {

    public int[] arrayAfterFour(int[] arr) throws RuntimeException{
        int[] newArr;
        int startIndex = - 1;
        for (int i = arr.length; i >= 0; i--){
            if (arr[i] == 4){
                startIndex = i + 1;
            }
        }
        if (startIndex == - 1){
            throw new RuntimeException();
        } else{
            newArr = Arrays.copyOfRange(arr, startIndex, arr.length - 1);
        }
        return newArr;
    }
}
