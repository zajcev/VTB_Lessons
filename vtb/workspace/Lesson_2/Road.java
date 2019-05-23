package vtb.workspace.lesson_2;

public class Road extends DoIt{
   private int distance;

   public Road(int distance){
       this.distance = distance;
   }
    @Override
    void doIt(Actions action) {
        action.run(distance);
    }
}
