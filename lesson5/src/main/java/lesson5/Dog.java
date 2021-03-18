package lesson5;

public class Dog extends Animal {

    private static int counter = 0;

    public Dog(String name) {
        super(name);
        counter++;
    }

    public Dog(String name, String color, int age) {
        super(name, color, age);
        counter++;
    }

    @Override
    public void run(int distance) {
        if (distance > 500) System.out.println("Собака не может пробежать более 500 метров");
        else super.run(distance);
    }

    @Override
    public void swim(int distance) {
        if (distance > 10) System.out.println("Собака не может проплыть более 10 метров");
        else super.swim(distance);
    }

    @Override
    public void getQuantityInfo() {
        System.out.printf("Всего объектов типа Dog было создано: %d\n", counter);
    }

}
