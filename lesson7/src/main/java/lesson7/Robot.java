package lesson7;

public class Robot implements Jumpable, Runable{
    public String name;
    private int max_length;
    private int max_height;
    private boolean isLeftTheRase = false;

    public Robot(String name, int max_height, int max_length) {
        this.name = name;
        this.max_height = max_height;
        this.max_length = max_length;
    }

    @Override
    public void jump(int height, Wall wall) {
        if (isAbilityJump(height, wall.height) && !isLeftTheRase) {
            System.out.printf("Робот, по имени %s, прыгнул на  %d метров вверх\n", name, height);
        } else if(isLeftTheRase){
            System.out.printf("Робот, по имени %s, не может участвовать, сошел с дистанции до этого препятствия\n", name);
        }
        else {
            System.out.printf("Робот, по имени %s, не смог перепрыгнуть стену, высотой %d метров", name, wall.height);
            System.out.printf("Робот, по имени %s, сошел с дисстанции\n", name);
            isLeftTheRase = true;
        }
    }

    @Override
    public void run(int distance, Treadmill treadmill) {
        if (isAbilityRun(distance, treadmill.length) && !isLeftTheRase){
            System.out.printf("Робот, по имени %s, пробежал %d метров\n", name, distance);
        } else if(isLeftTheRase){
            System.out.printf("Робот, по имени %s, не может участвовать, сошел с дистанции до этого препятствия\n", name);
        }
        else {
            System.out.printf("Робот, по имени %s, не смог пробежать заданных %d метров\n", name, treadmill.length);
            System.out.printf("Робот, по имени %s, сошел с дисстанции\n", name);
            isLeftTheRase = true;
        }
    }

    private boolean isAbilityRun(int length, int treadmillLength){
        return ((max_length >= length) && (treadmillLength <= length));

    }
    private boolean isAbilityJump(int height, int wallHeight){
        return ((max_height >= height)&& (wallHeight <= height));
    }
}
