package lesson4;

public class Main {

    public static void main(String[] args){
        Worker[] workerArray = new Worker[5];
        workerArray[0] = new Worker("Milakin", "Alexander", "Dmitrievich",30, "Junior embedded", "alex@mail.ru", "89114597863", 300000);
        workerArray[1] = new Worker("Aparina", "Olga", "Alexandrovna",22, "Engineer", "aparina@mail.ru", "89114123659", 50000);
        workerArray[2] = new Worker("Petrov", "Ivan", "Olegovich",65, "writer", "pi@gmail.ru", "89569841203", 150000);
        workerArray[3] = new Worker("Petrova", "Marina", "Ivanovna",58, "manager", "petrovaMI@toc.ru", "89856123045", 80000);
        workerArray[4] = new Worker("Wagner", "Pavel", "Pavlovich",41, "Engineer", "wagner_p_p@yandex.ru", "+7-956-41-87", 60000);

        getInfoOver40(workerArray);
    }

    private static void getInfoOver40(Worker[] workers){
        for(Worker worker:workers){
            if (worker.getAge() > 40){
                worker.getInfo();
                System.out.println();
            }
        }
    }
}
