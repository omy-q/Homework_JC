package lesson13;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MainClass {
    public static final int CARS_COUNT = 4;

    public static CyclicBarrier cd;

    public static Lock lock = new ReentrantLock();

    public static void main(String[] args) {

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(CARS_COUNT), new Road(40));
        Car[] cars = new Car[CARS_COUNT];

        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }

        cd = new CyclicBarrier(CARS_COUNT);
        for (int i = 0; i < cars.length; i++) {
            final Car car = cars[i];
            lock.lock();
            new Thread(() -> {
                try {
                    System.out.println(car.getName() + " готовится");
                    Thread.sleep(500 + (int)(Math.random() * 800));
                    System.out.println(car.getName() + " готов");
                    cd.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    car.run();
                }
            }).start();
        }
        lock.unlock();
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }

}




