package vtb.workspace.Lesson_2;

public class Robot implements Actions{
    public final String type = "Робот";
    private String name;
    private double maxJump;
    private int maxDistance;
    private boolean onDistance = true;


    public Robot(String name,int maxDistance,double maxJump){
        this.name = name;
        this.maxDistance = maxDistance;
        this.maxJump = maxJump;
    }
    @Override
    public void jump(double height) {
        if (!onDistance) return;
        if (maxJump < height){
            System.out.println(type+" "+name+" не смог перепрыгнуть и выбывает");
            onDistance = false;
        }else{
            System.out.println(type+" "+name+" перепрыгнул");
        }
    }
    @Override
    public void run(int distance) {
        if (!onDistance) return;
        if (maxDistance < distance){
            System.out.println(type+" "+name+" не смог пробежать и выбывает");
            onDistance = false;
        }else{
            System.out.println(type+" "+name+" пробежал");
        }
    }
    @Override
    public void info() {
        if (onDistance) System.out.println(type+" "+name+" преодолел все препятствия");
        else System.out.println(type+" "+name+" не справился");
    }
}
