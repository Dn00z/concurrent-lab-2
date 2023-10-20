import java.util.concurrent.Semaphore;

public class Rider implements Runnable {

    private int riderId;

    public Rider(int riderId) {
        this.riderId = riderId;
    }

    @Override
    public void run() {
        try {
            BusStop.getRiderWaitingSemaphore().acquire();  // acquiring to enter waiting list for bus

            System.out.println("Rider " + riderId + " is waiting for bus");

            BusStop.getBusArrivalSemaphore().acquire(); // acquire to update waiting riders

            BusStop.incrementRiderCount();

            BusStop.getBusArrivalSemaphore().release(); // release the lock for updating waiting riders

            BusStop.getBusBoardSemaphore().acquire(); // wait until boarding can happen

            System.out.println("Rider " + riderId + "is boarding to bus");

            BusStop.decrementRiderCount();

            if (BusStop.getRiderCount() == 0 ) {
                BusStop.getBusDepartureSemaphore().release(); // if there is no riders bus can depart
            } else {
                BusStop.getBusBoardSemaphore().release(); // allowing other riders to board to bus
            }

            BusStop.getRiderWaitingSemaphore().release(); // allowing other rider to enter bus stop

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
