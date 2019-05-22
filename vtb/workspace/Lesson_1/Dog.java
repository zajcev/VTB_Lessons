package Lesson_1;

public class Dog extends Animal{
    private final String type = "Собак";
    private String name;
    private int running = 500;
    private int swimming = 10;

    public Dog(String name){
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
    @Override
    public String getType() {
        return type;
    }
}
