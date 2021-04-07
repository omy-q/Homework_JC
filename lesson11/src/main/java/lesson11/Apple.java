package lesson11;

public class Apple extends Fruit{

    public Apple(Float weight){
        this.weight = weight;
    }

    @Override
    public Float getWeight() {
        return this.weight;
    }
}
