package lesson6;

public class BowlEat extends Dishes{

    public BowlEat(int food){
        super(food);
    }

    @Override
    public void decreaseFood(int quantity){
        if (this.food - quantity < 0){
            System.out.println("___В миске не достаточно корма, чтобы прокормить эту собаку___");
        } else super.decreaseFood(quantity);

    }

    @Override
    public void info(){
        System.out.println("В миске осталось еды в количестве: " + this.food);
    }
}
