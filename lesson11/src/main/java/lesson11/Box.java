package lesson11;

import java.util.ArrayList;
import java.util.Arrays;

public class Box <E extends Fruit>{

    private ArrayList<E> fruits = new ArrayList<>();
    private String boxType;

    public Box(String boxType, E fruit){
        this.boxType = boxType;
        this.fruits.add(fruit);
    }

    public Box(String boxType, E... fruits){
        this.boxType = boxType;
        this.fruits.addAll(Arrays.asList(fruits));
    }

    public void addFruit(E fruit){
        this.fruits.add(fruit);
    }

    public void addFruits(E... fruits){
        this.fruits.addAll(Arrays.asList(fruits));
    }

    public void changeBox(Box<E> anotherBox){
        this.fruits.addAll(anotherBox.fruits);
        anotherBox.fruits.clear();
    }

    public static <E extends Fruit> void printBox(Box<E> box){
        if (box.fruits.isEmpty()) System.out.print(box.boxType + ": empty box");
        else {
            System.out.print(box.boxType + ": [ ");
            for (E el:box.fruits) {
                System.out.print(el.getWeight() + " ");
            }
            System.out.print("]\n");
        }
    }

    public Double getWeight(){
        Double sumWeight = 0.0;
        for (E fruit:this.fruits){
            sumWeight += fruit.getWeight();
        }
        return sumWeight;
    }

    public boolean compare(Box<?> anotherBox){
        return (Math.abs((this.getWeight() - anotherBox.getWeight())) < 0.0001);
    }
}
