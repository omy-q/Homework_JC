package lesson7;

public class Human implements Jumpable, Runable{
    public String name;

    public Human(String name){
        this.name = name;
    }

    @Override
    public void jump(float distance) {
        System.out.printf("Человек, по имени /s, прыгнул на  /f метров вверх", this.name, distance);
    }

    @Override
    public void run(float distance) {
        System.out.printf("Человек по имени /s пробежал /f метров", this.name, distance);
    }
}
