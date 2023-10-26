import java.util.Random;

public class RiderCreator implements Runnable {
    @Override
    public void run() {
        int meanTime = 30;
        int riderId = 1;

        Random random = new Random();

        while (Thread.currentThread().isAlive()) {
            Rider newRider = new Rider(riderId);
            new Thread(newRider).start();
            riderId++;

            try {
                Thread.sleep(calculateSleepTime(meanTime, random));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }

    private long calculateSleepTime(int mean, Random random) {
        return Math.round(- Math.log(1- random.nextDouble()) * mean);
    }
}
