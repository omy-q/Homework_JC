package lesson8;

public class MainClass {

    public static void main(String[] args){

        String[][] correctArr = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        String[][] incorrectSizeArr1 = {
                {"1", "2", "3", "4"},
                {"5", "6", "7"},
                {"9", "10", "11", "12"},
                {"13", "14"}
        };

        String[][] incorrectSizeArr2 = {
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        String[][] incorrectDataArr = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "ten", "11", "12"},
                {"13", "14", "15", "16"}
        };

        try {
            getArraySum(incorrectDataArr);
        } catch (MyArraySizeException | MyArrayDataException e){
            e.printStackTrace();
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
