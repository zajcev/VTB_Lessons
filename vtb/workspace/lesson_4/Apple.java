package vtb.workspace.lesson_4;

public class Apple extends Fruit {
    private final int weight = 1;
    private final String type = "Apple";

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public String getType() { return type; }
}
