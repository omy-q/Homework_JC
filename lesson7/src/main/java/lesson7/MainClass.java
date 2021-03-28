package lesson7;

public class MainClass {

    public static void main(String args[]){

        Human human1 = new Human("Миша",200, 1500);
        Human human2 = new Human("Вася",150, 900);
        Robot robot1 = new Robot("CR13", 230, 2000);
        Robot robot2 = new Robot("Саша",500, 2500);
        Cat cat1 = new Cat("Мурзик",180, 500);
        Cat cat2 = new Cat("Муся",150, 450);

        Treadmill[] treadmills= new Treadmill[2];
        treadmills[0] = new Treadmill(1000);
        treadmills[1] = new Treadmill(500);

        Wall[] walls = new Wall[2];
        walls[0] = new Wall(100);
        walls[1] = new Wall(200);

        for (int i = 0; i < 2; i++) {
            human1.jump(200, walls[i]);
            human2.jump(150, walls[i]);
            robot1.jump(600, walls[i]);
            robot2.jump(100, walls[i]);
            cat1.jump(300, walls[i]);
            cat2.jump(120, walls[i]);

            System.out.println();

            human1.run(1000, treadmills[i]);
            human2.run(800, treadmills[i]);
            robot1.run(3200, treadmills[i]);
            robot2.run(400, treadmills[i]);
            cat1.run(500, treadmills[i]);
            cat2.run(350, treadmills[i]);

            System.out.println();

        }
    }
}
