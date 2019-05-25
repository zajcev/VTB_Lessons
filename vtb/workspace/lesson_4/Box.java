package vtb.workspace.lesson_4;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    private String type;
    private List<T> place = new ArrayList<>();


    public void put(T obj) {
        if (place.isEmpty()) type = obj.getType();
        if (type == obj.getType()) place.add(obj);
        else System.out.println("В коробке другие фрукты");
    }

    public int getWeight() {
        if (place.isEmpty()) return 0;
        return place.get(0).getWeight() * place.size();
    }

    public boolean compare(Box box) {
        return this.getWeight() == box.getWeight();
    }

    public void replace(Box other) {
        if (type == other.type) {
            other.place.addAll(place);
            place.clear();
        } else
            System.out.println("Яблоки с апельсинками мешать нельзя");
    }
}
