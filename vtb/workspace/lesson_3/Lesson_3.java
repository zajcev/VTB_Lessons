package vtb.workspace.lesson_3;

public class Lesson_3 {
    private static final String[][] numbers = {{"1","1","1","1"},
                                               {"1","1","1","1"},
                                               {"1","1","1","1"},
                                               {"1","3","1"}};

    public static void main(String[] args) throws MyArrayDataException, MySizeArrayException {
        System.out.println(convertToInt(numbers));
    }

    private static int convertToInt(String[][] numbers) throws MyArrayDataException, MySizeArrayException {
        int result = 0;

        for(int i = 0; i < numbers.length; i++){
            if (numbers[i].length != 4 || numbers.length != 4) throw new MySizeArrayException("Размер массива не 4x4");
            for (int j = 0; j < numbers.length; j++){
                try {
                    result+=Integer.parseInt(numbers[i][j]);
                }catch (NumberFormatException e){
                    throw new MyArrayDataException(i,j);
                }
            }
        }
        return result;
    }
}
