package vtb.workspace.lesson_5;

import java.util.HashMap;
import java.util.Map;

public class Lesson_5 {
    private static final String[] words = {"one","two","three","one","four","two","one","one","two","three","five"};

    public static void main(String[] args) {
        countWords(words);

        Handbook handbook = new Handbook();
        handbook.add("Ivanov",1231231231);
        handbook.add("Ivanov",1231631231);
        handbook.add("Ivanov",1231231271);
        handbook.add("Sidorov",1231231271);
        handbook.add("Sidorov",1231831271);
        handbook.add("Ivanov",1231931271);
        handbook.add("Sidorov",1234531271);
        handbook.add("Petrov",1237831271);
        handbook.add("Ivanov",1231031271);
        handbook.get("Ivanov");
    }

    private static void countWords(String[] arr){
        Map<String,Integer> box = new HashMap<>();
        for (String word : arr) {
            if (box.containsKey(word)) box.put(word,box.get(word) + 1);
            else box.put(word,1);
        }
        System.out.println(box.toString().replaceAll("^\\{|\\}$", ""));
    }
}
