package lesson12;

import java.util.Arrays;

public class MainClass {

    public static final int SIZE = 100_000_000;
    public static final int HALF = SIZE / 2;

    public static void main(String[] args){
        createArr();

    }

    public static float[] createArr(){

        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1);
        long timeStart = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++){
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long timeFinish = System.currentTimeMillis();
        System.out.println("Lead time: " + (timeFinish - timeStart) + "ms");
        return arr;
    }
}
