package vtb.workspace.lesson_5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Handbook {
    private Map<String, List<Long>> telephones = new HashMap<>();

    protected void add(String name, long number){
        List<Long> list = new ArrayList<>();
        if (telephones.containsKey(name)){
         telephones.get(name).add(number);
        } else {
         list.add(number);
         telephones.put(name,list);
        }
    }
    protected void get(String name){
        if (telephones.containsKey(name))
            System.out.println("Телефонные номера по фамилии "+name+" - "+telephones.get(name).toString().replaceAll("^\\[|\\]$", ""));
        else System.out.println("Фамилии "+name+" нет в справочнике");
    }
}
