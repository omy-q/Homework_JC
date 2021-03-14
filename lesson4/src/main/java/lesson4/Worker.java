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

    public void getInfo(){
        System.out.println("Surname %s name %s patronymic %s \nage %", surname, name, patronymic, age);
        System.out.println("Position: %s \nEmail: %s \nTelephone: %ss \nSalary: %\n", position, email, telephone, salary);
    }
}
