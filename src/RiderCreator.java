public class RiderCreator implements Runnable {
    @Override
    public void run() {
        int meanTime = 20 * 60;
        int riderId = 1;

        while (Thread.currentThread().isAlive()) {
            Rider newRider = new Rider(riderId);

            new Thread(newRider).start();

            meanTime ++;

            try {
                Thread.sleep(meanTime);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
