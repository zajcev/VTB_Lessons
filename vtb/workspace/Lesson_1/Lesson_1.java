package vtb.workspace.lesson_1;

import java.util.HashMap;

public class Lesson_1 {

    public static void main(String[] args) {
        HashMap<String,Integer> hm = new HashMap<>();
        String type;
        int animalCounter = 0;
        Animal[] animals = {new Dog("Bob"),new HomeCat("James"),
                            new Tiger("Arr"),new Dog("Bubaleh"),
                            new Tiger("John"), new Dog("Arch")
        };
        for (Animal a : animals) {
            a.run(100);
            a.swim(50);
            type = a.getType();
            if (hm.containsKey(type)){
                Integer value = hm.get(type) + 1;
                hm.put(type,value);
                animalCounter++;
            }else{
                hm.put(type,1);
                animalCounter++;
            }
        }
        System.out.println("Создано "+hm);
        System.out.println("Всего создано животных = "+animalCounter);
    }
}

