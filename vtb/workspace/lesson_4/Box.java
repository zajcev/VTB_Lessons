package vtb.workspace.lesson_4;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    T obj;
    private List<T> place;

    public Box(T obj){
        this.obj = obj;
        this.place = new ArrayList<>();
    }

    public void put(T obj){
        place.add(obj);
    }

    public int getWeight() {
        return place.get(0).getWeight() * place.size();
    }

    public boolean compare(Box box){
        return this.getWeight() == box.getWeight();
    }

    public void replace(Box <? super T> other) {
                other.place.addAll(place);
                place.clear();
    }
}
