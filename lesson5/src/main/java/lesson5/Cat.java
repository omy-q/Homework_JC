package lesson5;

public class Cat extends Animal {

    private static  int counter = 0;

    public Cat(String name) {
        super(name);
        counter++;
    }

    public Cat(String name, String color, int age) {
        super(name, color, age);
        counter++;
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

    @Override
    public void getQuantityInfo() {
        System.out.printf("Всего объектов типа Cat было создано: %d\n", counter);
    }

}
