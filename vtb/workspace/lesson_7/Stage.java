package vtb.workspace.lesson_7;

/**
 * @author Mikhail Zaitsev
 */
public abstract class Stage {
    protected int length;
    protected String description;
    public String getDescription() {
        return description;
    }
    public abstract void go(Car c);
}
