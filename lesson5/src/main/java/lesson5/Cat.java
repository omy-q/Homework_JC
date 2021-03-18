package lesson5;

public class Cat extends Animal {

    public Cat(String name) {
        super(name);
    }

    public Cat(String name, String color, int age) {
        super(name, color, age);
    }

    @Override
    public void run(int distance) {
        if (distance > 200) System.out.println("Кот не может пробежать более 200 метров");
        else super.run(distance);
    }

    @Override
    public void swim(int distance) {
        System.out.println("Кот не умеет плавать");
    }

}
