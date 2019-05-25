package vtb.workspace.lesson_4;

public class Orange extends Fruit {
    private final int weight = 2;
    private final String type = "Orange";

    @Override
    public int getWeight() { return weight; }

    @Override
    public String getType() { return type; }
}
