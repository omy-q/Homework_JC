package lesson11;

public class Orange extends Fruit{

    public Orange(Float weight){
        this.weight = weight;
    }

    @Override
    public Float getWeight() {
        return this.weight;
    }
}
