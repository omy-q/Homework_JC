package lesson8;

public class MainClass {

    public static void main(String[] args){

    }

    private static void getArraySum(String[][] arr){
        if (arr.length != 4) throw new MyArraySizeException();
        for (int i = 0; i < arr.length; i++){
            if (arr[i].length != 4) throw new MyArraySizeException();
            int sum = 0;
            for (int j = 0; j < 4; j++){
                try {
                    sum += Integer.parseInt(arr[i][j]);
                }
                catch (RuntimeException e){
                    throw new MyArrayDataException();
                }
            }
        }
    }

}
