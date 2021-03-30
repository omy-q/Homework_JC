package lesson8;

public class MainClass {

    public static void main(String[] args){

        String[][] correctArr = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        String[][] incorrectSizeArr1 = {};
        String[][] incorrectSizeArr2 = {};
        String[][] incorrectDataArr = {};

        try {
            getArraySum(correctArr);
        } catch (MyArraySizeException e){
            e.printStackTrace();
        } catch (MyArrayDataException e){
            System.out.println(e.getMessage());
        }

    }

    private static void getArraySum(String[][] arr){
        if (arr.length != 4) throw new MyArraySizeException();
        int sum = 0;
        for (int i = 0; i < arr.length; i++){
            if (arr[i].length != 4) throw new MyArraySizeException();
            for (int j = 0; j < 4; j++){
                try {
                    sum += Integer.parseInt(arr[i][j]);
                }
                catch (RuntimeException e){
                    throw new MyArrayDataException("in the cell[" + i + "][" + j + "] contains incorrect data!");
                }
            }
        }
        System.out.println("Сумма всех элементов двумерного массива 4х4 равна: " + sum);
    }

}
