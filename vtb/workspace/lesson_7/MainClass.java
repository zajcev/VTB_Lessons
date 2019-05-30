package vtb.workspace.lesson_7;

import java.util.concurrent.*;

/**
 * @author Mikhail Zaitsev
 */
public class MainClass {
    public static final int CARS_COUNT = 4;
    private static CyclicBarrier cyclicBarrier;
    private static ExecutorService executorService;
    private static CountDownLatch countDownLatch;


    public static void main(String[] args) throws InterruptedException{
        cyclicBarrier = new CyclicBarrier(CARS_COUNT, new StartRace());
        executorService = Executors.newSingleThreadExecutor();
        countDownLatch = new CountDownLatch(CARS_COUNT);

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        executorService.execute(() -> {
            for(int i = 0; i < CARS_COUNT; i++){
                Car car = new Car(race, 20 + (int) (Math.random() * 10),cyclicBarrier,countDownLatch);
                new Thread(car).start();
            }
        });
        executorService.shutdown();
        countDownLatch.await();
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }

}
class StartRace implements Runnable {
    @Override
    public void run() {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
    }
}
