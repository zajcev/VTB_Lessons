package vtb.workspace.lesson_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lesson_4 {
    private static Integer[] forConvert = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    private static List<Integer> byValue = new ArrayList<>();

    public static void main(String[] args) {
        DoSomeWithList doSomeWithList = new DoSomeWithList();
        doSomeWithList.replace(forConvert, 0, 9);
        byValue = doSomeWithList.convertToArray(forConvert);
        System.out.println(byValue);
        doSomeWithList.replaceByValue(byValue, 0, 9);
    }
}

class DoSomeWithList<T> {

    public void replace(T[] array, int firstIndex, int secondIndex){
            T memory = array[firstIndex];
            array[firstIndex] = array[secondIndex];
            array[secondIndex] = memory;
    }

    public void replaceByValue(List<T> arrayList, T first, T second) { // не удержался и сделал через ArrayList замену по значению
        int firstIndex = arrayList.indexOf(first);
        int secondIndex = arrayList.indexOf(second);

        if (firstIndex == -1) { System.out.println("Первое значение не найдено"); return; }
        if (secondIndex == -1) { System.out.println("Второе значение не найдено"); return; }
        arrayList.set(firstIndex, second);
        arrayList.set(secondIndex, first);
        System.out.println(arrayList);
    }

    public List convertToArray(T[] arr) {
        return Arrays.asList(arr);
    }
}