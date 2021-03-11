package lesson3;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    private static final char dot_X = 'x';
    private static final char dot_O = 'o';
    private static final char dot_EMPTY = '.';

    private static int size;
    private static char[][] field;

    private static final Random rand = new Random();
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args){

        System.out.println("\n     Здравствуй, Игрок, попробуй свою удачу и логику");
        System.out.println(" в игре 'Крестики-нолики' против искусственного интеллекта\n");
        printRulls();
        getFieldSize();
        initField();
        printField();
        do{
            humanTurn();
            if (checkWin(dot_X)){
                printField();
                System.out.println("Победа Игрока");
                break;
            }
            aiTurn();
            if (checkWin(dot_O)){
                printField();
                System.out.println("Победа искусственного интеллекта");
                break;
            }
            printField();
        } while(true);
    }

    private static void initField(){
        field = new char[size][size];
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                field[i][j] = dot_EMPTY;
            }
        }
    }
    private static void printField(){
        System.out.print("   ");
        for (int i = 1; i <= size; i++) {
            System.out.print(" " + i + "  ");
        }
        System.out.print("\n   ");
        for (int i = 0; i < size; i++) {
            System.out.print("--- ");
        }
        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.print(i + 1 + " |");
            for (int j = 0; j < size; j++) {
                System.out.print(" " + field[i][j] + " |");
            }
            System.out.print("\n   ");
            for (int k = 0; k < size; k++) {
                System.out.print("--- ");
            }
            System.out.println();
        }
        System.out.println();
    }
    private static void getFieldSize(){
        System.out.println(" Введите размер поля (любое целое число, больше 3)");
        size = sc.nextInt();
        while(!isValidSize(size)){
            System.out.println(" Вы ввели неверный размер поля, повторите ввод:\r");
            size = sc.nextInt();
        }
    }

    private static boolean isValidSize(int a){
        return (a > 3);
    }


    private static void humanTurn(){
        int x, y;
        System.out.println(" Введите координаты поля, куда будете ставить знак:\r");
        x = sc.nextInt() - 1;
        y = sc.nextInt() - 1;
        while(!isCellValid(x,y) || !isCellEmpty(x,y)){
            System.out.println(" Вы ввели неверные координаты, повторите ввод:\r");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        }
        field[x][y] = dot_X;
    }
    private static void aiTurn(){
        int x, y;
        do {
            x = rand.nextInt(size);
            y = rand.nextInt(size);
        } while (!isCellValid(x, y) || !isCellEmpty(x, y));
        field[x][y] = dot_O;
    }
    private static boolean isCellValid(int x, int y){
        return(0<=x && x<size && 0<=y && y<size);
    }
    private static boolean isCellEmpty(int x, int y) {
        return (field[x][y] == dot_EMPTY);
    }
    private static boolean checkWin(char dot){
        int count = 0;
        for (int i = 0; i < size; i++){
            for (int j = 1; j < size; j++){
                if (field[i][j] == dot &&  field[i][j-1] == dot) {
                    count++;
                } else {
                    count = 0;
                }
            }
            if (isSomebodyWin(count)){
                return true;
            }
            count = 0;
        }
        for (int j = 0; j < size; j++){
            for (int i = 1; i < size; i++) {
                if (field[i][j] == dot &&  field[i-1][j] == dot) {
                    count++;
                } else {
                    count = 0;
                }
            }
            if (isSomebodyWin(count)){
                return true;
            }
            count = 0;
        }
        for (int i = 1, j = 1; i < size && j < size; i++, j++){
            if (field[i][j] == dot &&  field[i-1][j-1] == dot) {
                count++;
            } else {
                count = 0;
            }
        }
        if (isSomebodyWin(count)) {
            return true;
        }
        count = 0;
        for (int i = 1, j = size-2; i < size && j >= 0; i++, j--){
            if (field[i][j] == dot &&  field[i-1][j+1] == dot) {
                count++;
            } else {
                count = 0;
            }
        }
        return isSomebodyWin(count);
    }

    private static boolean isSomebodyWin(int count){
        return (count == size - 1);
    }

    private static void printRulls(){
        String[] rulls = {"  Игрок и искусственный интеллект по очереди ставят на свобод-",
                        "ные клетки поля, размер которого задает игрок, фигурки ( игрок",
                        "ходит крестиками, искусственный интеллект - ноликами ).",
                        "  Первый, выстроивший в ряд  по вертикали, горизонтали или диа-",
                        "гонали свои фигуры в количестве, равном размерам поля, выигры-",
                        "вает. ",
                        "  Первый ход делает игрок, ставящий крестики."
        };
        System.out.println("-------------------------Правила игры-------------------------\n");
        for (String string:rulls){
            System.out.println(string);
        }
        System.out.println("--------------------------------------------------------------\n");
    }

}
