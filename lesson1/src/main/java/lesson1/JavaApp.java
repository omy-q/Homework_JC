package lesson1;

public class JavaApp {
    public static void main(String[] args){

        // Объявление и инициализация примитивных переменных
        byte byteVar = 15;
        short shortVar = 30245;
        int intVar = 154201689;
        long longVar = -4521064892225L;
        float floatVar = -16235.545f;
        double doubleVar = 154.12564;
        char charVar = 'e';
        boolean booleanVar = true;
        // Объявление и инициализация ссылочных переменных
        String stringVar = "HelloWorld!";

        // Вызов методов для пунктов 3-8
       System.out.println("Результат работы метода для пункта 3: " + method3(10, 15, 7, 4));
       System.out.println("Результат работы метода для пунтка 4: " + method4(17, -5));
       method5(-56);
       System.out.println("Результат работы метода для пунтка 6: " + method6(-9));
       method7("Alexander");
       method8(2008);


    }
    private static double method3(int a, int b, int c, int d) {
        return a * (b + (1.0 * c / d));
    }
    private static boolean method4(int a, int b) {
        return ((a + b) >=10 && (a + b) <= 20);
    }
    private static void method5(int a) {
        String result = "Число " + a + " положительное";
        if (a < 0) result = "Число " + a + " отрицательное";
        System.out.println("Результат работы метода для пунтка 5: " + result);
    }
    private static boolean method6(int a) {
        return (a < 0);
    }
    private static  void method7(String name) {
        System.out.println("Результат работы метода для пунтка 7: Привет, " + name + "!");
    }
    private static  void method8(int year) {
        String result = year + " - не високосный год";
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            result = year + " - високосный год";
        }
        System.out.println("Результат работы метода для пунтка 8: " + result);
    }
}
