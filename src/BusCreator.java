public class BusCreator implements Runnable{
    @Override
    public void run() {

        int busId = 1;
        int meanTime = 30;

        while (Thread.currentThread().isAlive()) {
            Bus newBus = new Bus(busId);
            new Thread(newBus).start();

            busId ++;

            try {
                Thread.sleep(meanTime);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
