package vtb.workspace.Lesson_1;

public class HomeCat extends Animal{
    protected final String type = "Котеек";
    private String name;
    private int running = 200;

    public HomeCat(String name){
        this.name = name;
    }

    @Override
    public void swim(int distance){
            System.out.println(name+" не умеет плавать");
    }
    @Override
    public void run(int distance){
        if (running >= distance){
            System.out.println(name+" пробежал "+distance+" метров");
        }else{
            System.out.println(name+" не смог столько пробежать");
        }
    }
    @Override
    public String getType() {
        return type;
    }
}
