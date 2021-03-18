package lesson5;

public class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }

    public Dog(String name, String color, int age) {
        super(name, color, age);
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

}
