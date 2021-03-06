package vtb.workspace.lesson_7;

import java.util.concurrent.Semaphore;
import static vtb.workspace.lesson_7.MainClass.CARS_COUNT;

/**
 * @author Mikhail Zaitsev
 */
public class Tunnel extends Stage {
    private Semaphore semaphore = new Semaphore(CARS_COUNT/2);

    public Tunnel() {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }
    @Override
    public void go(Car c) {
        try {
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                semaphore.acquire();
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
                System.out.println(c.getName() + " закончил этап: " + description);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
    }

}
