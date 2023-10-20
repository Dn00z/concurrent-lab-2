public class Bus implements Runnable {

    private int busId;

    public Bus(int busId) {
        this.busId = busId;
    }

    @Override
    public void run() {
        try {
            BusStop.getBusArrivalSemaphore().acquire(); // acquiring to arrive to bus stop
            System.out.println("Bus " + busId + " arrived\n" + "Waiting riders: " + BusStop.getRiderCount());

            if (BusStop.getRiderCount() > 0) {
                BusStop.getBusBoardSemaphore().release(); // if there are riders, signaling boarding
                BusStop.getBusDepartureSemaphore().acquire(); // wait until departure is possible
            }
            System.out.println("Bus " + busId + " departed");

            BusStop.getBusArrivalSemaphore().release(); // releasing after departed

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
