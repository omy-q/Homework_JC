package lesson12;

import java.util.Arrays;

public class MainClass {

    public static final int SIZE = 100_000_000;
    public static final int HALF = SIZE / 2;


    public static void main(String[] args) throws InterruptedException {
        createArr();

    }

    public static void createArr(){
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1);
        long timeStart = System.currentTimeMillis();

        for (int i = 0; i < SIZE; i++){
            arr[i] = changeArrayElement(arr[i], i);
        }

        long timeFinish = System.currentTimeMillis();
        System.out.println("Lead time: " + (timeFinish - timeStart) + "ms");
    }

    public static float changeArrayElement(float elem, int index){
            elem = (float)(elem * Math.sin(0.2f + index / 5) * Math.cos(0.2f + index / 5) * Math.cos(0.4f + index / 2));
        return elem;
    }

}
