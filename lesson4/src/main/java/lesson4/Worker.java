package lesson4;

public class Worker {

    private String surname;
    private String name;
    private String patronymic;
    private int age;

    private String position;
    private String email;
    private String telephone;

    private int salary;

    public Worker(String surname, String name, String patronymic, int age, String position, String email, String telephone, int salary) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.age = age;

        this.position = position;
        this.email = email;
        this.telephone = telephone;
        this.salary = salary;
    }

    public int getAge(){
        return age;
    }

    public void getInfo(){
        System.out.printf("%s %s %s\n", surname, name, patronymic);
        System.out.printf("Age: %d \n", age);
        System.out.printf("Position: %s \n", position);
        System.out.printf("Email: %s \n", email);
        System.out.printf("Telephone: %ss \n", telephone);
        System.out.printf("Salary: %d\n", salary);

    }
}
