package lesson3;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    private static char dot_Human;
    private static char dot_Ai;
    private static final char dot_EMPTY = ' ';

    private static int[] aiPoint = {0, 0};
    private static int[] humanPoint;

    private static int goal;
    private static int size;
    private static char[][] field;

    private static final Random rand = new Random();
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("\n     Здравствуй, Игрок, попробуй свою удачу и логику");
        System.out.println(" в игре 'Крестики-нолики' против искусственного интеллекта\n");
        printRules();
        do {
            getFieldSize();
            getGoal();
            getHumanDot();
            initField();
            printField();
            playGames();
            System.out.println("Хотите сыграть еще раз? Если да, введите: 'y'");
            if (!sc.next().equalsIgnoreCase("y")) break;
        } while (true);
    }

    private static void getHumanDot(){
        System.out.println("Выберите фигуру, какой будете ходить: X или O");
        dot_Human = sc.next().charAt(0);
        if (dot_Human == 'X') dot_Ai = 'O';
        else dot_Ai = 'X';
    }

    private static void playGames() {
        do {
            if (dot_Human == 'X') {
                humanTurn(dot_Human);
                if (checkWin(humanPoint[0], humanPoint[1])) {
                    printField();
                    System.out.println("Победа Игрока");
                    break;
                }
                if (isDraw()) {
                    printField();
                    System.out.println("Ничья");
                    break;
                }
                aiTurn(dot_Ai);
                if (checkWin(aiPoint[0], aiPoint[1])) {
                    printField();
                    System.out.println("Победа искусственного интеллекта");
                    break;
                }
            } else{
                aiTurn(dot_Ai);
                if (checkWin(aiPoint[0], aiPoint[1])) {
                    printField();
                    System.out.println("Победа искусственного интеллекта");
                    break;
                }
                printField();
                if (isDraw()) {
                    printField();
                    System.out.println("Ничья");
                    break;
                }
                humanTurn(dot_Human);
                if (checkWin(humanPoint[0], humanPoint[1])) {
                    printField();
                    System.out.println("Победа Игрока");
                    break;
                }
            }
            if (isDraw()) {
                printField();
                System.out.println("Ничья");
                break;
            }
            printField();
        } while (true);

    }

    private static void getFieldSize() {
        System.out.println("Введите размер поля (любое целое число, больше 2)");
        size = sc.nextInt();
        while (!isValidSize(size)) {
            System.out.println("Вы ввели неверный размер поля, повторите ввод:\r");
            size = sc.nextInt();
        }
    }

    private static boolean isValidSize(int a) {
        return (a >= 3);
    }

    private static void getGoal() {
        System.out.println("Введите целое число, которое задает победное количество подряд стоящих фигур, не больше размера поля");
        goal = sc.nextInt();
        while (goal > size) {
            System.out.println("Вы ввели неверное число, повторите ввод:\r");
            goal = sc.nextInt();
        }
    }

    private static void initField() {
        field = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                field[i][j] = dot_EMPTY;
            }
        }
    }

    private static void printField() {
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

    private static void humanTurn(char dot) {
        int x, y;
        System.out.println(" Введите координаты поля, куда будете ставить знак:\r");
        x = sc.nextInt() - 1;
        y = sc.nextInt() - 1;
        while (!isCellValid(x, y) || !isCellEmpty(x, y)) {
            System.out.println(" Вы ввели неверные координаты, повторите ввод:\r");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        }
        humanPoint = new int[]{x, y};
        field[humanPoint[0]][humanPoint[1]] = dot;
    }

    private static void aiTurn(char dot) {
        int x, y;
        if (humanPoint == null || (!isWinTurnHuman(dot_Human) && !isWinTurnAi(dot_Ai))){
            do {
                x = rand.nextInt(size);
                y = rand.nextInt(size);
            } while (!isCellValid(x, y) || !isCellEmpty(x, y));
            aiPoint =  new int[]{x, y};
        }
        field[aiPoint[0]][aiPoint[1]] = dot;
    }

    private static boolean isWinPoint (int x, int y, char dot){
        if (isCellValid(x, y) && isCellEmpty(x, y)){
            field[x][y] = dot;
            if (checkWin(x, y)){
                field[x][y] = dot_EMPTY;
                aiPoint[0] = x;
                aiPoint[1] = y;
            return true;
            }
            field[x][y] = dot_EMPTY;
        }
        return false;
    }

    private static boolean isWinTurnAi(char dot) {
        int x = aiPoint[0] + 1, y = aiPoint[1];
        if (isWinPoint(x, y, dot)) return true;

        x = aiPoint[0] - 1; y = aiPoint[1];
        if (isWinPoint(x, y, dot)) return true;

        x = aiPoint[0]; y = aiPoint[1] + 1;
        if (isWinPoint(x, y, dot)) return true;

        x = aiPoint[0]; y = aiPoint[1] - 1;
        if (isWinPoint(x, y, dot)) return true;

        x = aiPoint[0] + 1; y = aiPoint[1] + 1;
        if (isWinPoint(x, y, dot)) return true;

        x = aiPoint[0] - 1; y = aiPoint[1] - 1;
        if (isWinPoint(x, y, dot)) return true;

        x = aiPoint[0] + 1; y = aiPoint[1] - 1;
        if (isWinPoint(x, y, dot)) return true;

        x = aiPoint[0] - 1; y = aiPoint[1] + 1;
        return isWinPoint(x, y, dot);
    }

    private static boolean isWinTurnHuman(char dot) {
        int x = humanPoint[0] + 1, y = humanPoint[1];
        if (isWinPoint(x, y, dot)) return true;

        x = humanPoint[0] - 1; y = humanPoint[1];
        if (isWinPoint(x, y, dot)) return true;

        x = humanPoint[0]; y = humanPoint[1] + 1;
        if (isWinPoint(x, y, dot)) return true;

        x = humanPoint[0]; y = humanPoint[1] - 1;
        if (isWinPoint(x, y, dot)) return true;

        x = humanPoint[0] + 1; y = humanPoint[1] + 1;
        if (isWinPoint(x, y, dot)) return true;

        x = humanPoint[0] - 1; y = humanPoint[1] - 1;
        if (isWinPoint(x, y, dot)) return true;

        x = humanPoint[0] + 1; y = humanPoint[1] - 1;
        if (isWinPoint(x, y, dot)) return true;

        x = humanPoint[0] - 1; y = humanPoint[1] + 1;
        return isWinPoint(x, y, dot);
    }

    private static boolean isCellValid(int x, int y) {
        return (0 <= x && x < size && 0 <= y && y < size);
    }

    private static boolean isCellEmpty(int x, int y) {
        return (field[x][y] == dot_EMPTY);
    }

    private static boolean checkWin(int x, int y) {
        //поиск по строкам
        int count = 0;
        for (int xi = x + 1; xi < size; xi++) {
            if (field[xi][y] == field[x][y]) {
                count++;
            } else break;
        }
        for (int xi = x - 1; xi >= 0; xi--) {
            if (field[xi][y] == field[x][y]) {
                count++;
            } else break;
        }
        if (isWin(count)) return true;

        //поиск по столбцам
        count = 0;
        for (int yi = y + 1; yi < size; yi++) {
            if (field[x][yi] == field[x][y]) {
                count++;
            } else break;
        }
        for (int yi = y - 1; yi >= 0; yi--) {
            if (field[x][yi] == field[x][y]) {
                count++;
            } else break;
        }
        if (isWin(count)) return true;


        // поиск по диагонали главной
        count = 0;
        for (int xi = x + 1, yi = y + 1; xi < size && yi < size; xi++, yi++) {
            if (field[xi][yi] == field[x][y]) {
                count++;
            } else break;
        }
        for (int xi = x - 1, yi = y - 1; xi >= 0 && yi >= 0; xi--, yi--) {
            if (field[xi][yi] == field[x][y]) {
                count++;
            } else break;
        }
        if (isWin(count)) return true;

        // поиск по диагонали побочной
        count = 0;
        for (int xi = x - 1, yi = y + 1; xi >= 0 && yi < size; xi--, yi++) {
            if (field[xi][yi] == field[x][y]) {
                count++;
            } else break;
        }
        for (int xi = x + 1, yi = y - 1; xi < size && yi >= 0; xi++, yi--)
            if (field[xi][yi] == field[x][y]) {
                count++;
            } else break;
        return (isWin(count));
    }

    private static boolean isDraw() {
        for (char[] raw : field) {
            for (char symbol : raw) {
                if (symbol == dot_EMPTY) return false;
            }
        }
        return true;
    }

    private static boolean isWin(int count) {
        return (count >= goal - 1);
    }

    private static void printRules() {
        String[] rulls = {"  Игрок и искусственный интеллект по очереди ставят на свобод-",
                "ные клетки поля, размер которого задает игрок, фигурки. Игрок ",
                "выбирает какой фигуркой он будет ходить: крестиком или ноликом.",
                "Искусственный интеллект ходит той фигурой, которая осталась.",
                "  Первый, выстроивший в ряд  по вертикали, горизонтали или диа-",
                "гонали свои фигуры в количестве, заданном игроком, выигрывает. ",
                "  Первый ход делает игрок, ставящий крестики."
        };
        System.out.println("-------------------------Правила игры-------------------------\n");
        for (String string : rulls) {
            System.out.println(string);
        }
        System.out.println("--------------------------------------------------------------\n");
    }

}
