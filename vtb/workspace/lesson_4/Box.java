package vtb.workspace.lesson_4;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private String type;
    private ArrayList<T> place = new ArrayList<>();

    public void put(T obj) {
        if (place.isEmpty()) type = obj.getType();
        if (type == obj.getType()) place.add(obj);
        else System.out.println("В коробке другие фрукты");
    }

    public int getWeight() {
        int weight = 0;
        for (T fruit : place) {
            weight += fruit.getWeight();
        }
        return weight;
    }

    public boolean compare(Box box) {
        if (this.getWeight() == box.getWeight()) {
            System.out.println("Коробки равны по весу");
            return true;
        }
        System.out.println("Коробки не равны по весу");
        return false;
    }


    public void replace(Box other) {
        if (type == other.type) {
            other.place.addAll(place);
            place.clear();
        } else
            System.out.println("Яблоки с апельсинками мешать нельзя");
    }
}
