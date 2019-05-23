package vtb.workspace.lesson_2;

public class Wall extends DoIt {
    private double height;

    public Wall(int height){
        this.height = height;
    }
    @Override
    void doIt(Actions action) {
         action.jump(height);
     }
}
