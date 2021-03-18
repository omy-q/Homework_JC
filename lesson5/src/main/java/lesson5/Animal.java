package lesson5;

public class Animal {

    private String name;
    private String color;
    private int age;

    private static int counter = 0;

    public Animal(String name){
        this.name = name;
        counter++;
    }

    public Animal(String name, String color, int age){
        this.name = name;
        this.color = color;
        this.age = age;
        counter++;
    }

    public void run(int distance) {
        System.out.printf("%s пробежал(а) %d метров.\n",this.name, distance);
    }

    public void swim(int distance) {
        System.out.printf("%s проплыл(а) %d метров.\n",this.name, distance);
    }

    public void getQuantityInfo() {
        System.out.printf("Всего объектов типа Animal было создано: %d\n", counter);
    }

}
