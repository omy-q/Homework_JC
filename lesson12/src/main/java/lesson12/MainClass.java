package lesson12;

import java.util.Arrays;

public class MainClass {

    public static final int SIZE = 100_000_000;
    public static final int HALF = SIZE / 2;


    public static void main(String[] args) throws InterruptedException {
        float[] arrOneThread = createArr();
        float[] arrTwoThread = createArrThread();
        System.out.println(Arrays.equals(arrOneThread, arrTwoThread));

    }

    public static float[] createArr(){
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1);
        long timeStart = System.currentTimeMillis();

        for (int i = 0; i < SIZE; i++){
            arr[i] = changeArrayElement(arr[i], i);
        }

        long timeFinish = System.currentTimeMillis();
        System.out.println("Lead time use one thread: " + (timeFinish - timeStart) + " ms");
        return arr;
    }

    public static float[] createArrThread() throws InterruptedException{
        float[] arr1 = new float[HALF];
        float[] arr2 = new float[HALF];
        float[] arr = new float[SIZE];

        Arrays.fill(arr, 1);
        long timeStart = System.currentTimeMillis();

        System.arraycopy(arr, 0, arr1, 0, HALF);
        System.arraycopy(arr, HALF, arr2, 0, HALF);

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < HALF; i++){
                arr1[i] = changeArrayElement(arr1[i], i);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < HALF; i++){
                arr2[i] = changeArrayElement(arr2[i], i + HALF);
            }
        });

        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.arraycopy(arr1, 0, arr, 0, HALF);
        System.arraycopy(arr2, 0, arr, HALF, HALF);

        long timeFinish = System.currentTimeMillis();
        System.out.println("Lead time use two thread: " + (timeFinish - timeStart) + " ms");
        return arr;
    }

    public static float changeArrayElement(float elem, int index){
            elem = (float)(elem * Math.sin(0.2f + index / 5) * Math.cos(0.2f + index / 5) * Math.cos(0.4f + index / 2));
        return elem;
    }

//    public static boolean equalsArrs(){}

}
