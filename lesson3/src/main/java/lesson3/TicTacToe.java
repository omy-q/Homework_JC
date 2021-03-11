package lesson3;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    private static final char dot_X = 'x';
    private static final char dot_O = 'o';
    private static final char dot_EMPTY = '.';

    private static final int size = 3;
    private static char[][] field;

    private static final Random rand = new Random();
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args){
        initField();
        printField();
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

}
