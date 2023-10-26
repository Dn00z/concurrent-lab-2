import java.util.Random;

public class BusCreator implements Runnable{
    @Override
    public void run() {

        int busId = 1;
        int meanTime = 20 * 60;
        Random random = new Random();

        while (Thread.currentThread().isAlive()) {
            Bus newBus = new Bus(busId);
            new Thread(newBus).start();
            busId ++;

            try {
                Thread.sleep(calculateSleepTime(meanTime, random));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private long calculateSleepTime(int mean, Random random) {
        return Math.round(-Math.log(1- random.nextDouble()) * mean);
    }
}
