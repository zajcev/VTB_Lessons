package vtb.workspace.lesson_1;

public class Tiger extends Animal {
    protected final String type = "Тигров";
    private String name;
    private int running = 550;
    private int swimming = 100;

    public Tiger(String name){
        this.name = name;
    }

    @Override
    public void swim(int distance){
        if (swimming >= distance){
            System.out.println(name+" проплыл "+distance+" метров");
        }else{
            System.out.println(name+" не смог столько проплыть");
        }
    }
    @Override
    public void run(int distance){
        if (running >= distance){
            System.out.println(name+" пробежал "+distance+" метров");
        }else{
            System.out.println(name+" не смог столько пробежать");
        }
    }
    public String getType() {
        return type;
    }
}
