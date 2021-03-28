package lesson7;

public class Human implements Jumpable, Runable{
    public String name;

    public Human(String name){
        this.name = name;
    }

    @Override
    public void jump(int height, Wall wall) {
        if (height >= wall.height) {
            System.out.printf("Человек, по имени /s, прыгнул на  /d метров вверх", this.name, height);
        } else{
            System.out.printf("Человек, по имени /s, не смог перепрыгнуть стену, высотой /d метров", this.name, wall.height);
        }
    }

    @Override
    public void run(int distance, Treadmill treadmill) {
        if (distance >= treadmill.distance) {
            System.out.printf("Человек, по имени /s пробежал /d метров", this.name, distance);
        } else{
            System.out.printf("Человек, по имени /s, не смог пробежать заданных /d метров", this.name, treadmill.distance);
        }
    }
}
