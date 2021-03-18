package lesson5;

public class MainClass {

    public static void main(String[] args){

        Dog dog1 = new Dog("Хоган", "черный",7);
        Dog dog2 = new Dog("Сэм");

        Cat cat1 = new Cat("Муся", "серый", 3);
        Cat cat2 = new Cat("Мурзик");

        dog1.run(20);
        dog2.run(5);
        cat1.swim(25);
        dog1.swim(16);
    }
}
