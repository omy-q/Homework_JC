package lesson9;

public class Dog {

    private String name;
    private String color;
    private int age;
    private String breed;



    public Dog(String name, int age, String color){
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public Dog(String name, int age, String color, String breed){
        this.name = name;
        this.age = age;
        this.color = color;
        this.breed = breed;
    }

    public void getInfo(){
        String str_breed = breed;
        if (str_breed == null) str_breed = "дворняжка";
        System.out.printf("Информация по данной собаке:\nимя: %s;\n" +
                                                         "возраст: %d;\n" +
                                                         "цвет: %s;\n" +
                                                         "порода: %s\n\n",
                         name, age, color, str_breed);
    }

    public String getName(){
        return name;
    }

    public String getColor(){
        return color;
    }

    public int getAge(){
        return age;
    }

    public String getBreed(){
        String str_breed = breed;
        if (str_breed == null) str_breed = "дворняжка";
        return str_breed;
    }

}
