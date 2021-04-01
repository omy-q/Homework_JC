package lesson9;

import java.sql.SQLException;

public class MainClass {

    public static void main(String[] args) {

        Dog[] dogs = new Dog[5];
        dogs[0] = new Dog("Хоган", 7, "черный", "лабрадор");
        dogs[1] = new Dog("Тузик", 10, "бело-рыжий");
        dogs[2] = new Dog("Джесика", 10, "бело-серый", "хаски");
        dogs[3] = new Dog("Цезарь", 3, "коричневый", "лабрадор");
        dogs[4] = new Dog("Сэм", 4, "серый");

        for (Dog dog:dogs) {
            dog.getInfo();
        }

        DataBase db = new DataBase();
        try {
            db.connect();
            db.createTable();
//            for (Dog dog:dogs) {
//                db.insertAllData(dog);
//            }
            db.readDB();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            db.disconnect();
        }


        try{
            db.connect();
            db.updateOneData("name", "'Шарик'", "name='Тузик'");
            db.updateTwoData("name", "'Мисси'", "age", "6", "id=3");
            db.readColumn("name", "age>4");
        }catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }finally {
            db.disconnect();
        }

    }
}
