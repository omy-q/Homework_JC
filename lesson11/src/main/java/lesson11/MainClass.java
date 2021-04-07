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

        Apple[] apples = {new Apple(0.56f),
                          new Apple(1.23f),
                          new Apple(0.35f),
                          new Apple(0.64f)};

        Orange[] oranges = {new Orange(0.85f),
                            new Orange(1.15f),
                            new Orange(0.96f),
                            new Orange(1.29f),
                            new Orange(0.76f)};


        Box<Apple> boxWithApple1 = new Box<>("Apples", apples);
        Box.printBox(boxWithApple1);
        Box<Orange> boxWithOrange1 = new Box<>("Oranges", oranges);
        Box.printBox(boxWithOrange1);

        Apple appleAdd = new Apple(0.46f);
        boxWithApple1.addFruit(appleAdd);
        Box.printBox(boxWithApple1);

        Orange orangeAdd = new Orange(0.63f);
        boxWithOrange1.addFruit(orangeAdd);
        Box.printBox(boxWithOrange1);

        System.out.println("Weight box with apples: " + boxWithApple1.getWeight());
        System.out.println("Weight box with oranges: " + boxWithOrange1.getWeight());

        System.out.println("Weight of these boxes is the same? Answer: " + boxWithApple1.compare(boxWithOrange1));

        Apple[] apples2 = {new Apple(0.12f),
                           new Apple(0.25f),
                           new Apple(0.94f),
                           new Apple(0.38f)};

        Box<Apple> boxWithApple2 = new Box<>("Apples", apples2);
        Box.printBox(boxWithApple2);

        boxWithApple1.changeBox(boxWithApple2);
        Box.printBox(boxWithApple1);
        Box.printBox(boxWithApple2);

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
