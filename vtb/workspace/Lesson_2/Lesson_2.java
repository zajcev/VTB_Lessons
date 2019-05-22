package vtb.workspace.Lesson_2;

public class Lesson_2 {
    public static void main(String[] args) {
        DoIt[] obstacles = {new Road(100),new Wall(1)};
        Actions[] players = {new Human("1",2,1),new Human("2",200,2),
                             new Robot("Chappi",10,2),new Robot("PathFinder",150,1.5),
                             new Cat("Barsik",101,0.5),new Cat("James",20,1.1)
        };
        for (DoIt obstacle : obstacles) {
            for (Actions player : players) {
                obstacle.doIt(player);
            }
        }
        for (Actions player : players) {
            player.info();
        }
    }
}
