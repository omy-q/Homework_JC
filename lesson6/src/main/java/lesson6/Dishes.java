package lesson6;

public abstract class Dishes {

    protected int food;

    public Dishes(int food){
        this.food = food;
    }

    public void decreaseFood(int quantity){
        food -= quantity;
    }

    public void increaseFood(int quantity){
        food += quantity;
    }

    public abstract void info();
}
