package lesson13;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MainClass {
    public static final int CARS_COUNT = 4;

    public static CyclicBarrier cd;

    public static CountDownLatch cdl_start;
    public static CountDownLatch cdl_finish;

    public static void main(String[] args) {

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(CARS_COUNT), new Road(40));
        Car[] cars = new Car[CARS_COUNT];

        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }

        cd = new CyclicBarrier(CARS_COUNT);
        cdl_start = new CountDownLatch(CARS_COUNT);
        cdl_finish = new CountDownLatch(CARS_COUNT);
        for (int i = 0; i < cars.length; i++) {
            final Car car = cars[i];
            new Thread(() -> {
                try {
                    System.out.println(car.getName() + " готовится");
                    Thread.sleep(500 + (int)(Math.random() * 800));
                    System.out.println(car.getName() + " готов");
                    cdl_start.countDown();
                    cd.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    car.run();
                    cdl_finish.countDown();
                }
            }).start();

        }

        try{
            cdl_start.await();
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");

        try{
            cdl_finish.await();
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }

}




