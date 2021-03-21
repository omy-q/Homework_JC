package lesson6;

public class MainClass {

    public static void main(String[] args){

        Dog[] dogs = {
                new Dog("Хоган", 20, 20),
                new Dog("Сэм", 10, 20),
                new Dog("Цезарь", 15, 30),
                new Dog("Леди", 5, 10),
                new Dog("Симба", 12, 15),
        };

        BowlWater bowlWater = new BowlWater();
        BowlEat bowlEat = new BowlEat(50);

        for (Dog dog:dogs) {
            dog.info();
            bowlWater.info();
            bowlEat.info();
            dog.eat(bowlEat);
            dog.drink(bowlWater);
            dog.info();
            bowlWater.info();
            bowlEat.info();
            dog.run();
            dog.swim();
            dog.eat(bowlEat);
            dog.drink(bowlWater);
            dog.info();
            bowlWater.info();
            bowlEat.info();
        }
    }
}
