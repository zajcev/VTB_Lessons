package vtb.workspace.lesson_4;

import java.util.ArrayList;

public class Lesson_4 {
    private static Integer[] forConvert = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    private static ArrayList<Integer> byValue;

    public static void main(String[] args) {
        DoSomeWithList doSomeWithList = new DoSomeWithList();

        doSomeWithList.replace(forConvert, 0, 9);
        byValue = doSomeWithList.convertToArray(forConvert);
        System.out.println(byValue);
        doSomeWithList.replaceByValue(byValue, 0, 9);
    }
}

class DoSomeWithList<T> {

    public void replace(T[] array, int firstIndex, int secondIndex) throws ArrayIndexOutOfBoundsException {
        try {
            T memory = array[firstIndex];
            array[firstIndex] = array[secondIndex];
            array[secondIndex] = memory;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    public void replaceByValue(ArrayList<T> arrayList, T first, T second) { // не удержался и сделал через ArrayList
        int firstIndex = arrayList.indexOf(first);
        int secondIndex = arrayList.indexOf(second);

        if (firstIndex == -1) {
            System.out.println("Первое значение не найдено");
            return;
        }
        if (secondIndex == -1) {
            System.out.println("Второе значение не найдено");
            return;
        }

        T memory = arrayList.get(firstIndex);
        arrayList.set(firstIndex, second);
        arrayList.set(secondIndex, memory);
        System.out.println(arrayList);
    }

    public ArrayList convertToArray(T[] arr) {
        ArrayList<T> result = new ArrayList<>();
        for (T object : arr) {
            result.add(object);
        }
        return result;
    }
}