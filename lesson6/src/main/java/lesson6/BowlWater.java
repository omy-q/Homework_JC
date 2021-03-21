package lesson6;

public class BowlWater extends Dishes{

    private final int waterDose = 50;

    public BowlWater() {
        super(50);
    }

    private void checkValid(){
        if (this.food <= 0)
            super.increaseFood(waterDose);

    }
    @Override
    public void decreaseFood(int quantity) {
        if (this.food - quantity < 0) {
            System.out.println("___В миске больше не осталось воды, автоматическое добавление___");
            super.increaseFood(waterDose);
        }
        super.decreaseFood(quantity);
        checkValid();
    }

    @Override
    public void info(){
        System.out.println("В миске осталось воды в количестве: " + this.food);
    }
}
