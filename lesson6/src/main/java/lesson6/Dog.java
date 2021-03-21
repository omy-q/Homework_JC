package lesson6;

public class Dog {

    private final String name;
    private final int appetiteEat;
    private final int appetiteDrink;
    private boolean hunger = true;
    private boolean thirst = true;

    public Dog(String name, int appetiteEat, int appetiteDrink){
        this.name = name;
        this.appetiteEat = appetiteEat;
        this.appetiteDrink = appetiteDrink;
    }

    private boolean isEnoughFood(BowlEat bowl){
        return (bowl.food - appetiteEat >= 0);

    }

    private boolean isDogHungry(){
        return (this.hunger);
    }

    private boolean isDogThirsty(){
        return (this.thirst);
    }

    public void eat(BowlEat bowl){
        if (isEnoughFood(bowl) && isDogHungry()){
            bowl.decreaseFood(appetiteEat);
            this.hunger = false;
        }
    }

    public void drink(BowlWater bowl){
        if (isDogThirsty()) {
            bowl.decreaseFood(appetiteDrink);
            this.thirst = false;
        }
    }

    public void run(){
        System.out.printf("%s побегал\n", this.name);
        this.hunger = true;
        this.thirst = true;
    }

    public void swim(){
        System.out.printf("%s поплавал\n", this.name);
        this.hunger = true;
        this.thirst = true;
    }

    public void info(){
        System.out.printf("Собака по имени %s голодная: %b, хочет пить: %b\n", this.name, this.hunger, this.thirst);
    }

}
